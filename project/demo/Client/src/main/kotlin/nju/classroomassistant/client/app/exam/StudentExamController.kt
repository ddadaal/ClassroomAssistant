package nju.classroomassistant.client.app.exam

import javafx.concurrent.Task
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.shared.exam.ExamService
import tornadofx.Controller

class StudentExamController: Controller() {
    val networkService: NetworkService by di()
    private val currentUserManager: CurrentUserManager by di()

    fun getCurrentExam() {

    }

    fun submitAnswerSheet(answers: List<Int>): Task<Unit> {
        networkService.call(ExamService::class) {

        }
    }
}