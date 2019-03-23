package nju.classroomassistant.client.app.exam

import javafx.concurrent.Task
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.shared.exam.ExamService
import nju.classroomassistant.shared.exam.vo.AnswerSheetVo
import nju.classroomassistant.shared.exam.vo.ExamVo
import tornadofx.Controller

class TeacherExamController: Controller() {
    val networkService: NetworkService by di()
    val currentUserManager: CurrentUserManager by di()

    var currentExam: ExamVo? = null

    fun getExamInformation(): Task<ExamVo?> {
        return runAsync {
            networkService.call(ExamService::class) {
                currentExam = it.getCurrentExam()
                currentExam
            }
        }
    }

    fun getAnswes(): Task<List<AnswerSheetVo>> {
        return runAsync {
            networkService.call(ExamService::class) {
                it.getAnswerSheetsOfAnExam(currentExam!!.id)
            }
        }
    }


}