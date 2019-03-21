package nju.classroomassistant.server.ping

import nju.classroomassistant.server.network.Export
import nju.classroomassistant.shared.ping.PingService
import nju.classroomassistant.shared.util.log
import java.rmi.server.UnicastRemoteObject

@Export
class PingServiceImpl: UnicastRemoteObject(), PingService {
    override fun ping() {
        log(this, "Ping received.")
    }

}