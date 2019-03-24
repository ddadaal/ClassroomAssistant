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
class InterNetworkServiceImpl : UnicastRemoteObject(), InterNetworkService {

    fun exportAll() {
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
                            export(clazz as Class<Remote>, instance)
                            break
                        }
                    }
                }
            }

        export(InterNetworkService::class.java, this)
    }

    private fun <T : Remote> export(service: Class<T>, instance: T) {
        val url = RmiHelper.generateRmiUrl(service.name)
        Naming.rebind(url, instance)

        log(
            "Service Exporter",
            String.format("registered %s to %s", url, instance.toString())
        )
    }

    override fun getServiceUrl(interfaceName: String): String {
        return RmiHelper.generateRmiUrl(interfaceName)
    }

}