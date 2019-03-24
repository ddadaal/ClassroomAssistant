package nju.classroomassistant.server.network

import nju.classroomassistant.shared.network.PingService
import nju.classroomassistant.shared.util.log
import java.rmi.server.UnicastRemoteObject

@Export
class PingServiceImpl: UnicastRemoteObject(), PingService {
    override fun ping() {
        log(this, "Ping received.")
    }

}