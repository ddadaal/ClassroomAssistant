package nju.classroomassistant.server.network

import io.github.classgraph.ClassGraph
import nju.classroomassistant.shared.network.InterNetworkService
import nju.classroomassistant.shared.util.RmiHelper
import nju.classroomassistant.shared.util.log
import java.rmi.Naming
import java.rmi.Remote
import java.rmi.registry.LocateRegistry
import java.rmi.server.UnicastRemoteObject
import kotlin.reflect.KClass

const val scanBase = "nju.classroomassistant.server"

@Suppress("UNCHECKED_CAST")
class InterNetworkServiceImpl: UnicastRemoteObject(), InterNetworkService {

    init {
        LocateRegistry.createRegistry(Integer.parseInt(RmiHelper.port))

        ClassGraph()
            .enableAllInfo()
            .whitelistPackages(scanBase)
            .scan()
            .use { scanResult ->
                val services = scanResult.getClassesWithAnnotation("$scanBase.network.Export")
                    .loadClasses()


                for (service in services) {
                    val instance = service.newInstance() as Remote

                    for (clazz in service.interfaces) {
                        if (Remote::class.java.isAssignableFrom(clazz)) {
                            val url = RmiHelper.generateRmiUrl(clazz.name)
                            log(
                                "Service Exporter",
                                String.format("registered %s to %s", url, instance.toString())
                            )
                            Naming.rebind(url, instance)
                            break
                        }
                    }
                }
            }

    }

    fun exportSelf() {
        val url = RmiHelper.generateRmiUrl(InterNetworkService::class.java.name)
        Naming.rebind(url, this)

        log(
            "Service Exporter",
            String.format("registered %s to %s", url, toString())
        )
    }

    override fun getServiceUrl(interfaceName: String): String {
        return RmiHelper.generateRmiUrl(interfaceName)
    }

}