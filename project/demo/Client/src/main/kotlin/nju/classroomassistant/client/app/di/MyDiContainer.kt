package nju.classroomassistant.client.app.di

import nju.classroomassistant.shared.di.CADiContainer
import tornadofx.DIContainer
import kotlin.reflect.KClass

const val scanBase = "nju.classroomassistant.client.app"

class MyDiContainer : DIContainer {

    private val container = CADiContainer(scanBase)

    override fun <T : Any> getInstance(type: KClass<T>): T {
        return container.getInstance(type)
    }

}

