package nju.classroomassistant.client.view.checkin

import javafx.collections.FXCollections
import javafx.scene.Parent
import nju.classroomassistant.client.app.checkin.TeacherCheckinController
import nju.classroomassistant.shared.util.Id
import tornadofx.*

class TeacherCheckinView: View("教师签到") {

    val controller: TeacherCheckinController by inject()

    val checkedInStudents = FXCollections.observableArrayList<Id>()

    override val root: Parent = vbox {
        listview(checkedInStudents)
        button("刷新") {
            action {
                update()
            }
        }
        separator { }
        button("返回") {
            action {
                controller.currentUserManager.backToHome(this@TeacherCheckinView)
            }
        }
    }

    fun update() {
        controller.update() ui {
            checkedInStudents.clear()
            checkedInStudents.addAll(it)
        }
    }

    override fun onDock() {
        update()
    }
}