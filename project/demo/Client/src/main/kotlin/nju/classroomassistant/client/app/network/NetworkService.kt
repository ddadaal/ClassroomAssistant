package nju.classroomassistant.client.app.network

import nju.classroomassistant.client.app.di.Service
import tornadofx.Controller
import java.rmi.Remote
import kotlin.reflect.KClass

@Service
interface NetworkService {
    fun <T: Remote, R> call(service: KClass<T>, callback: (T) -> R): R

    fun connect()
}