package nju.classroomassistant.server.network

import io.github.classgraph.ClassGraph
import nju.classroomassistant.shared.util.RmiHelper
import nju.classroomassistant.shared.util.log
import java.rmi.Naming
import java.rmi.Remote
import java.rmi.registry.LocateRegistry

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Export


fun exportServices() {
    val rootService = InterNetworkServiceImpl()
    rootService.exportSelf()
}