package nju.classroomassistant.client.app.network

import nju.classroomassistant.shared.ping.PingService
import nju.classroomassistant.shared.util.RmiHelper
import nju.classroomassistant.shared.util.log
import java.rmi.Naming
import javax.xml.bind.JAXBElement
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


const val PING_INTERVAL = 5000L

class PingMonitor(
    var pingService: PingService,
    val pingFailed: () -> Unit
) {

    private var start = true

    private val thread = GlobalScope.launch {
        while (true) {
            try {
                if (start) {
                    log("PingMonitor", "Start ping.")
                    pingService.ping()
                    log("PingMonitor", "Ping success.")
                    if (start) {
                        delay(PING_INTERVAL)
                    }
                }
            } catch (e: Exception) {
                log("PingMonitor", "Network is interrupted.")
                pingFailed()
            }
        }

    }

    init {
        thread.start()
    }


    fun start(pingService: PingService?) {
        if (pingService != null) {
            this.pingService = pingService
        }
        start = true
    }

    fun pause() {
        start = false
    }

    fun stop() {
        start = false
        thread.cancel()
    }
}