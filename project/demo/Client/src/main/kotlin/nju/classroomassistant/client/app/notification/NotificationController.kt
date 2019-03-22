package nju.classroomassistant.client.app.notification

import javafx.collections.FXCollections
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.client.view.notification.NotificationView
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.notification.NotificationService
import nju.classroomassistant.shared.notification.vo.NotificationVo
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
            it.broadcast(content)
        }
    }

    fun init() {
    }
}