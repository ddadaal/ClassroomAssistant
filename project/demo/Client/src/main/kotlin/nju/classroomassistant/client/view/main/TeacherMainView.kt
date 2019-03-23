package nju.classroomassistant.client.view.main

import nju.classroomassistant.client.app.main.TeacherMainController
import nju.classroomassistant.client.view.checkin.TeacherCheckinView
import nju.classroomassistant.client.view.filemanagement.FileView
import nju.classroomassistant.client.view.notification.NotificationView
import nju.classroomassistant.client.view.raisehands.TeacherRaiseHandsView
import tornadofx.*

class TeacherMainView : View("教室功能菜单") {
    val controller: TeacherMainController by inject()
    override val root = vbox {

        button("签到信息") {
            action {
                replaceWith<TeacherCheckinView>(sizeToScene = true)
            }
        }
        button("举手") {
            action {
                replaceWith<TeacherRaiseHandsView>(sizeToScene = true)
            }
        }
        button("讨论") {

        }
        button("文件管理") {
            action {
                replaceWith<FileView>(sizeToScene = true)
            }
        }
        button("考试") {

        }
        button("通知") {
            action {
                replaceWith<NotificationView>(sizeToScene = true)
            }
        }
        separator { }
        button("退出") {
            action {
                close()
            }
        }
    }
}
