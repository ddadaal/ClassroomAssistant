package nju.classroomassistant.client.view.discussion

import javafx.beans.property.SimpleStringProperty
import nju.classroomassistant.client.app.discussion.StudentDiscussionController
import tornadofx.*

class StudentDiscussionView : View("My View") {

    val controller: StudentDiscussionController by inject()

    val currentQuestion = SimpleStringProperty()

    val input = SimpleStringProperty()

    override val root = vbox {
        label("当前问题")
        textfield {
            isEditable = false
            text(currentQuestion)
        }
        button("刷新问题") {
            action {
                refreshQuestion()
            }
        }
        separator { }
        textfield {
            text(input)
        }
        button("发送") {
            action {
                controller.send(input.get())
                input.set("")
                information("发送成功!")
            }
        }
        separator { }
        button("返回") {
            action {
                controller.currentUserManager.backToHome(this@StudentDiscussionView)
            }
        }
    }

    override fun onDock() {
        refreshQuestion()
    }

    private fun refreshQuestion() {
        controller.getCurrentQuestion() ui {
            currentQuestion.set(it)
        }
    }
}
