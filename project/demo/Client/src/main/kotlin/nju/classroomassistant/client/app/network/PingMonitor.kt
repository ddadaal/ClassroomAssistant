package nju.classroomassistant.client.app.network

import nju.classroomassistant.shared.network.PingService
import nju.classroomassistant.shared.util.log
import kotlinx.coroutines.*


const val PING_INTERVAL = 5000L

interface PingMonitor {
    fun start(pingService: PingService?)

    fun pause()

    fun stop()
}

class PingMonitorImpl (
    var pingService: PingService,
    val pingFailed: () -> Unit
): PingMonitor {

    private var start = true

    private val thread = GlobalScope.launch {
        while (true) {
            try {
                if (start) {
                    log("PingMonitor", "Start ping.")
                    pingService.ping()
                    log("PingMonitor", "Ping success.")
                    delay(PING_INTERVAL)
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


    override fun start(pingService: PingService?) {
        if (pingService != null) {
            this.pingService = pingService
        }
        start = true
    }

    override fun pause() {
        start = false
    }

    override fun stop() {
        start = false
        thread.cancel()
    }
}