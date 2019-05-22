package nju.classroomassistant.client.view.notification

import javafx.beans.property.SimpleBooleanProperty
import javafx.collections.FXCollections
import javafx.scene.control.Alert
import javafx.scene.control.ListCell
import javafx.scene.control.TextInputDialog
import nju.classroomassistant.client.app.notification.NotificationController
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.client.view.main.StudentMainView
import nju.classroomassistant.client.view.main.TeacherMainView
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.notification.vo.NotificationVo
import tornadofx.*

class NotificationView : View("My View") {

    val controller: NotificationController by inject()

    val currentUserManager: CurrentUserManager by di()

    val notifications = FXCollections.observableArrayList<NotificationVo>()
    val enabled = SimpleBooleanProperty(false)


    override val root = vbox {
        listview(notifications)
        button("刷新") {
            action {
                updateNotifications()
            }
        }
        button("发送通知") {
            enableWhen { enabled }
            action {
                val dialog = TextInputDialog()

                dialog.headerText = "输入通知内容"

                dialog.showAndWait().ifPresent {
                    controller.send(it)

                }

                information("发送成功","推送信息发送成功！")
            }
        }
        separator { }
        button("返回") {
            action {
                currentUserManager.backToHome(this@NotificationView)
            }
        }

    }

    fun updateNotifications() {
        controller.updateNotifications() ui {
            notifications.clear()
            notifications.addAll(it)
        }
    }

    override fun onDock() {
        updateNotifications()

        currentUserManager.withCurrentUser {
            enabled.set(it.role == UserRole.TEACHER)
        }

    }
}
