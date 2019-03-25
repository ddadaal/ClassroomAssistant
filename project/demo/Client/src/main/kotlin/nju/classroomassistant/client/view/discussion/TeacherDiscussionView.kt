package nju.classroomassistant.client.view.discussion

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.Parent
import javafx.scene.control.TextInputDialog
import nju.classroomassistant.client.app.discussion.TeacherDiscussionController
import tornadofx.*

class TeacherDiscussionView: View("教师讨论管理") {

    val controller: TeacherDiscussionController by inject()

    val currentQuestion = SimpleStringProperty()

    val list = FXCollections.observableArrayList<String>()

    override val root: Parent = vbox {
        label("当前问题")
        textfield(currentQuestion) {
            isEditable = false
        }
        button("开始新的问题") {
            action {
                val dialog = TextInputDialog()

                dialog.headerText = "输入讨论标题"

                dialog.showAndWait().ifPresent {
                    controller.startDiscussion(it) ui {
                        information("成功","已经开始了新的讨论")
                    }

                    updateConversation()
                }


            }
        }
        separator { }
        label("讨论")
        listview(list)
        separator { }
        button("返回") {
            action {
                controller.currentUserManager.backToHome(this@TeacherDiscussionView)
            }
        }
    }

    fun updateConversation() {
        controller.getCurrentDiscussion() ui {
            list.clear()
            list.addAll(it.posts.map { post -> post.content })
            currentQuestion.set(it.title)
        }
    }
}