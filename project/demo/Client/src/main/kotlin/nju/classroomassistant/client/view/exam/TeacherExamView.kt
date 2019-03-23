package nju.classroomassistant.client.view.exam

import javafx.collections.FXCollections
import javafx.scene.Parent
import nju.classroomassistant.client.app.exam.TeacherExamController
import nju.classroomassistant.shared.exam.vo.AnswerSheetVo
import nju.classroomassistant.shared.exam.vo.ExamVo
import nju.classroomassistant.shared.util.Id
import tornadofx.*

data class SubmittedSheet(val sheet: AnswerSheetVo, val exam: ExamVo) {
    override fun toString(): String {
        // calculate result
        var score = 0

        sheet.answers.forEachIndexed { index, answer ->
            if (answer == exam.questions[index].correctAnswerIndex) {
                score++
            }
        }

        return "学生：${sheet.userId.short()}，得分：$score"
    }
}

class TeacherExamView: View("教师考试界面") {

    val controller: TeacherExamController by inject()

    val answers = FXCollections.observableArrayList<SubmittedSheet>()


    override val root: Parent = vbox {
        listview(answers)
        separator { }
        button("发起新考试") {
            action {

            }
        }
        button("返回") {
            action {
                controller.currentUserManager.backToHome(this@TeacherExamView)
            }
        }
    }

    private fun updateAnswers() {
        controller.getAnswes() ui {
            answers.clear()
            answers.addAll(it.map { sheet -> SubmittedSheet(sheet, controller.currentExam!!) })
        }
    }

    override fun onDock() {

        controller.getExamInformation()

        updateAnswers()

        super.onDock()
    }
}