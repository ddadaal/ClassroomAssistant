package nju.classroomassistant.server.di

import nju.classroomassistant.shared.di.CADiContainer
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

const val scanBase = "nju.classroomassistant.server"

val container = CADiContainer(scanBase)

inline fun <reified T : Any> di(): ReadOnlyProperty<Any, T> {
    return object : ReadOnlyProperty<Any, T> {
        override fun getValue(thisRef: Any, property: KProperty<*>): T {
            return container.getInstance(T::class)
        }
    }
}