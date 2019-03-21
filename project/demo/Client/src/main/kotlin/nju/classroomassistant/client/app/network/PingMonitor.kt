package nju.classroomassistant.client.app.network

import nju.classroomassistant.shared.ping.PingService
import nju.classroomassistant.shared.util.RmiHelper
import nju.classroomassistant.shared.util.log
import java.rmi.Naming


const val PING_INTERVAL = 5000L

class PingMonitor(
    var pingService: PingService,
    val pingFailed: (thisRef: PingMonitor) -> Unit
) {

    private var start = true

    private val thread = Thread(Runnable {
        while (true) {
            try {
                if (start) {
                    log(this, "Start ping.")
                    pingService.ping()
                    log(this, "Ping success.")
                    Thread.sleep(PING_INTERVAL)
                }
            } catch (e: Exception) {
                log(this, "Network is interrupted.")
                pingFailed(this)
            }
        }

    })

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
        thread.interrupt()
    }
}