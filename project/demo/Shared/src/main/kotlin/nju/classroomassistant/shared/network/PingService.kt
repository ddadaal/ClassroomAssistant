package nju.classroomassistant.shared.network

import java.rmi.Remote
import java.rmi.RemoteException

interface PingService: Remote {

    @Throws(RemoteException::class)
    fun ping()
}