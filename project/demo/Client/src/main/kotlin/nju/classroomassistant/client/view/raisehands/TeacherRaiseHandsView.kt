package nju.classroomassistant.client.view.raisehands

import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.scene.control.SelectionMode
import nju.classroomassistant.client.app.raisehands.TeacherRaiseHandsController
import nju.classroomassistant.shared.util.Id
import tornadofx.*

class TeacherRaiseHandsView : View("My View") {

    val controller: TeacherRaiseHandsController by inject()

    val list = FXCollections.observableArrayList<Id>()

    val selectedId = SimpleObjectProperty<Id>()

    override val root = vbox {
        listview(list) {
            selectionModel.selectionMode = SelectionMode.SINGLE
            bindSelected(selectedId)

        }
        button("开始") {
            action {
                list.clear()
                controller.start()
            }

        }
        button("刷新") {
            action {
                list.clear()
                list.addAll(controller.people)
            }
        }
        button("选中学生") {

            enableWhen { selectedId.isNotNull }

            action {
                controller.select(selectedId.get())
            }
        }
        separator { }
        button("返回") {
            action {
                controller.currentUserManager.backToHome(this@TeacherRaiseHandsView)
            }
        }
    }
}
