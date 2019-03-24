package nju.classroomassistant.shared.di

import io.github.classgraph.ClassGraph
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class CADiContainer(scanBase: String) {

    private val annotationBase = "nju.classroomassistant.shared.di"

    private val map = mutableMapOf<Class<*>, Any?>()

    init {
        ClassGraph()
            .enableAllInfo()
            .whitelistPackages(scanBase)
            .scan()
            .use { scanResult ->
                val services = scanResult.getClassesWithAnnotation("$annotationBase.Service")
                    .loadClasses()

                val impls = scanResult.getClassesWithAnnotation("$annotationBase.ServiceImpl")


                for (service in services) {
                    map[service] = impls.find { it.implementsInterface(service.name) }?.loadClass()?.newInstance()
                }
            }

    }

    fun <T : Any> getInstance(type: KClass<T>): T {
        return map[type.java] as T? ?: throw NotProvidedException()
    }
}
