package nju.classroomassistant.client.app.notification

import javafx.concurrent.Task
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.client.view.notification.NotificationView
import nju.classroomassistant.shared.notification.NotificationService
import nju.classroomassistant.shared.notification.vo.NotificationVo
import tornadofx.Controller

class NotificationController: Controller() {

    val networkService: NetworkService by di()
    val currentUserManager: CurrentUserManager by di()


    fun updateNotifications(): Task<List<NotificationVo>> {

        return runAsync {
            currentUserManager.checkLogin()

            networkService.call(NotificationService::class) {
                it.getNotifications(currentUserManager.currentUser!!.id)
            }

        }



    }

    fun send(content: String) {
        networkService.call(NotificationService::class) {
            it.addNotification(content)
        }
    }
}