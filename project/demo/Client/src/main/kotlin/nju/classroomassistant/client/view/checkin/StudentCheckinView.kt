package nju.classroomassistant.client.view.checkin

import nju.classroomassistant.client.app.checkin.StudentCheckinController
import tornadofx.*

class StudentCheckinView : View("My View") {

    val controller: StudentCheckinController by inject()

    override val root = vbox {
        button("签到") {
            action {
                controller.checkin()
                information("签到成功!", "您已经签到成功！")
            }
        }
        separator { }
        button("返回") {
            action {
                controller.currentUserManager.backToHome(this@StudentCheckinView)
            }
        }
    }
}
