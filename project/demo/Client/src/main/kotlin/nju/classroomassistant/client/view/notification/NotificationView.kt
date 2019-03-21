package nju.classroomassistant.client.view.notification

import nju.classroomassistant.client.app.notification.NotificationController
import tornadofx.*

class NotificationView : View("My View") {

    val controller: NotificationController by inject()

    override val root = borderpane {
        listview(controller.list)
    }
}
