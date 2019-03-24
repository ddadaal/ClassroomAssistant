package nju.classroomassistant.client.app.exam

import javafx.concurrent.Task
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.shared.exam.ExamService
import nju.classroomassistant.shared.exam.vo.AnswerSheetVo
import nju.classroomassistant.shared.exam.vo.ExamVo
import tornadofx.Controller

class StudentExamController: Controller() {
    val networkService: NetworkService by di()
    val currentUserManager: CurrentUserManager by di()

    private var currentExam: ExamVo? = null

    fun getCurrentExam() {
        currentExam = networkService.call(ExamService::class) {
            it.getCurrentExam()
        }
    }

    fun submitAnswerSheet(answers: List<Int>): Task<Unit> {

        return runAsync {
            if (currentExam != null) {
                networkService.call(ExamService::class) {
                    it.submitAnswerSheet(AnswerSheetVo(currentUserManager.currentUser!!.id, answers))
                }
            }

        }
    }
}