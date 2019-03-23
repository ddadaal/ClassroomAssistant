package nju.classroomassistant.client.app

import nju.classroomassistant.client.app.di.MyDiContainer
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.view.login.LoginView
import nju.classroomassistant.client.view.login.Styles
import tornadofx.App
import tornadofx.FX
import tornadofx.launch

class Client : App(LoginView::class, Styles::class) {
    init {
        Thread.setDefaultUncaughtExceptionHandler(ErrorHandler())
        FX.dicontainer = MyDiContainer()
    }
}

fun main() {
    launch<Client>()
}