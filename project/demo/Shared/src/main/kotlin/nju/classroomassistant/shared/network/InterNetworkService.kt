package nju.classroomassistant.shared.network

import java.rmi.Remote
import java.rmi.RemoteException
import kotlin.reflect.KClass

interface InterNetworkService: Remote {

    @Throws(RemoteException::class)
    fun getServiceUrl(interfaceName: String): String
}