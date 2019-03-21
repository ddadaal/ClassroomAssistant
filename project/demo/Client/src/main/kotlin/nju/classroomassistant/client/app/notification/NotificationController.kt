package nju.classroomassistant.client.app.notification

import javafx.collections.FXCollections
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.UserService
import nju.classroomassistant.shared.notification.NotificationService
import nju.classroomassistant.shared.notification.vo.NotificationVo
import tornadofx.Controller

class NotificationController: Controller() {

    val networkService: NetworkService by di()
    val userService: UserService by di()

    val list = FXCollections.observableArrayList<NotificationVo>()

    fun updateNotifications() {

        userService.checkLogin()

        list.clear()
        list.addAll(networkService.call(NotificationService::class) {
             it.getNotifications(userService.currentUser!!.id)
        })

    }
}