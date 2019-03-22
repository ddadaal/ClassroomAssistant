package nju.classroomassistant.client.app.notification

import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.client.view.notification.NotificationView
import nju.classroomassistant.shared.notification.NotificationService
import tornadofx.Controller

class NotificationController: Controller() {

    val view: NotificationView by inject()
    val networkService: NetworkService by di()
    val currentUserManager: CurrentUserManager by di()


    fun updateNotifications() {

        runAsync {
            currentUserManager.checkLogin()

            networkService.call(NotificationService::class) {
                it.getNotifications(currentUserManager.currentUser!!.id)
            }

        } ui {
            view.notifications.clear()
            view.notifications.addAll(it)
        }



    }

    fun send(content: String) {
        networkService.call(NotificationService::class) {
            it.addNotification(content)
        }
    }

    fun init() {
    }
}