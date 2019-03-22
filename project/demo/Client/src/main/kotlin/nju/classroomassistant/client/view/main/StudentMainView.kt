package nju.classroomassistant.client.view.main

import nju.classroomassistant.client.app.main.StudentMainController
import nju.classroomassistant.client.view.notification.NotificationView
import tornadofx.*

class StudentMainView : View("学生功能菜单") {

    val controller: StudentMainController by inject()

    override val root = vbox {

        button("举手") {

        }
        button("讨论") {

        }
        button("文件管理") {

        }
        button("参加考试") {

        }
        button("通知") {
            action {
                replaceWith<NotificationView>(sizeToScene = true)
            }
        }
        separator {  }
        button("退出") {
            action {
                close()
            }
        }
    }
}
