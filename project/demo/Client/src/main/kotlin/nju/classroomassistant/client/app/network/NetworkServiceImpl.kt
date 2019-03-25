package nju.classroomassistant.client.app.network

import nju.classroomassistant.shared.di.ServiceImpl
import nju.classroomassistant.shared.network.InterNetworkService
import nju.classroomassistant.shared.network.PingService
import nju.classroomassistant.shared.util.RmiHelper
import nju.classroomassistant.shared.util.log
import java.rmi.Naming
import java.rmi.Remote
import kotlin.reflect.KClass

enum class NetworkState {
    NOT_CONNECTED,
    CONNECTED,
    INTERFERED
}

const val RETRY_COUNT = 10

@Suppress("UNCHECKED_CAST")
@ServiceImpl
class NetworkServiceImpl : NetworkService {

    private var state = NetworkState.NOT_CONNECTED
    private var pingMonitor: PingMonitor? = null
    private var networkService: InterNetworkService? = null

    @Synchronized
    private fun changeState(state: NetworkState) {
        this.state = state
    }

    @Synchronized
    private fun ensureConnected() {
        if (state != NetworkState.CONNECTED) {
            log(this, "Network is interfered. Attempting to reconnect.")
            tryReconnect()
        }
    }

    override fun connect() {

        log(this, "Attempt to connect to ${RmiHelper.baseUrl}.")

        try {

            networkService = lookupObject(InterNetworkService::class)

            state = NetworkState.CONNECTED


            log(this, "Connected.")

            pingMonitor = PingMonitorImpl(getObjectFromService(PingService::class)) {
                pingMonitor!!.pause()
                changeState(NetworkState.INTERFERED)
                tryReconnect()
            }

        } catch (e: Exception) {
            throw NetworkException()
        }


    }


    private fun <T : Remote> lookupObject(service: KClass<T>): T {
        return Naming.lookup(RmiHelper.generateRmiUrl(service.java.name)) as T
    }

    private fun <T: Remote> getObjectFromService(service: KClass<T>): T {
        return Naming.lookup(networkService?.getServiceUrl(service.java.name)) as T
    }


    private fun tryReconnect() {
        if (state == NetworkState.CONNECTED || state == NetworkState.NOT_CONNECTED) {
            return
        }

        var count = 0
        while (count < RETRY_COUNT) {
            try {

                log(this, "${count + 1} attempt to reconnect")

                networkService = lookupObject(InterNetworkService::class)

                state = NetworkState.CONNECTED

                log(this, "Reconnected.")

                pingMonitor?.start(getObjectFromService(PingService::class))

                return
            } catch (e: Exception) {
                count++
            }
        }

        pingMonitor!!.stop()
        log(this, "Network disconnected after $RETRY_COUNT attempts to reconnect.")
        throw NetworkException()
    }

    override fun <T : Remote, R> call(service: KClass<T>, callback: (T) -> R): R {

        ensureConnected()

        val remoteObj = lookupObject(service)

        return callback(remoteObj)
    }


}
