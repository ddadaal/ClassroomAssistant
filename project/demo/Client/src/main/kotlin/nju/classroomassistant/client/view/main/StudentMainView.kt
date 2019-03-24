package nju.classroomassistant.client.view.main

import nju.classroomassistant.client.app.main.StudentMainController
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.view.checkin.StudentCheckinView
import nju.classroomassistant.client.view.checkin.TeacherCheckinView
import nju.classroomassistant.client.view.discussion.StudentDiscussionView
import nju.classroomassistant.client.view.exam.StudentExamView
import nju.classroomassistant.client.view.filemanagement.FileView
import nju.classroomassistant.client.view.notification.NotificationView
import nju.classroomassistant.client.view.raisehands.StudentRaiseHandsView
import tornadofx.*

class StudentMainView : View("学生功能菜单") {

    val controller: StudentMainController by inject()

    override val root = vbox {
        button("签到信息") {
            action {
                replaceWith<StudentCheckinView>(sizeToScene = true)
            }
        }
        button("举手") {

            action {
                replaceWith<StudentRaiseHandsView>(sizeToScene = true)

            }
        }
        button("讨论") {
            action {
                replaceWith<StudentDiscussionView>(sizeToScene = true)

            }
        }
        button("文件管理") {

            action {
                replaceWith<FileView>(sizeToScene = true)

            }
        }
        button("参加考试") {
            action {
                replaceWith<StudentExamView>(sizeToScene = true)

            }
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
