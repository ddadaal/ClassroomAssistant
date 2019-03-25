package nju.classroomassistant.client.app

import nju.classroomassistant.client.app.network.NetworkException
import tornadofx.App
import tornadofx.DefaultErrorHandler
import tornadofx.error

class ErrorHandler : Thread.UncaughtExceptionHandler {

    private val defaultErrorHandler = DefaultErrorHandler()

    override fun uncaughtException(t: Thread, e: Throwable) {
        if (e is NetworkException) {
            error(
                "Network is disconnected",
                "Network is disconnected. Please exit the app"
            )
        } else {
            defaultErrorHandler.uncaughtException(t, e)
        }
    }

}
