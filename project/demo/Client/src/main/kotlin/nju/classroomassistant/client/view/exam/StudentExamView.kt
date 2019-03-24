package nju.classroomassistant.client.view.exam

import javafx.beans.property.SimpleStringProperty
import nju.classroomassistant.client.app.exam.StudentExamController
import tornadofx.*

class StudentExamView : View("My View") {

    val controller: StudentExamController by inject()

    val answer = SimpleStringProperty()

    override val root = vbox {

        label("问题")
        textfield {
            isEditable = false
            text("问题1")
        }
        label("输入答案")
        textfield(answer) {
        }
        button("提交") {
            action {
                val ans = answer.get().toIntOrNull()
                if (ans == null) {
                    error("请输入数字！")
                } else {
                    controller.submitAnswerSheet(listOf(ans))
                    information("成功", "试卷提交成功！")
                }
            }
        }
        separator { }
        button("返回") {
            action {
                controller.currentUserManager.backToHome(this@StudentExamView)
            }
        }
    }
}
