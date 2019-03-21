package nju.classroomassistant.client.app.di

import io.github.classgraph.ClassGraph
import tornadofx.Component
import tornadofx.DIContainer
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

const val scanBase = "nju.classroomassistant.client.app"

@Suppress("UNCHECKED_CAST")
class MyDiContainer : DIContainer {

    private val map = mutableMapOf<Class<*>, Any?>()

    init {
        ClassGraph()
            .enableAllInfo()
            .whitelistPackages(scanBase)
            .scan()
            .use { scanResult ->
                val services = scanResult.getClassesWithAnnotation("$scanBase.di.Service")
                    .loadClasses()

                val impls = scanResult.getClassesWithAnnotation("$scanBase.di.ServiceImpl")


                for (service in services) {
                    map[service] = impls.find { it.implementsInterface(service.name) }?.loadClass()?.newInstance()
                }
            }

    }

    override fun <T : Any> getInstance(type: KClass<T>): T {
        return map[type.java] as T? ?: throw NotProvidedException()
    }

}

