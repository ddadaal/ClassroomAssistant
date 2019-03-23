package nju.classroomassistant.server.exam

import nju.classroomassistant.server.database.DatabaseService
import nju.classroomassistant.server.di.di
import nju.classroomassistant.server.network.Export
import nju.classroomassistant.server.permission.PermissionService
import nju.classroomassistant.shared.exam.ExamService
import nju.classroomassistant.shared.exam.vo.AnswerSheetVo
import nju.classroomassistant.shared.exam.vo.ExamVo
import nju.classroomassistant.shared.exam.vo.QuestionVo
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.util.Id
import java.rmi.server.UnicastRemoteObject
import java.time.Duration
import java.time.LocalDateTime

@Export
class ExamServiceImpl : UnicastRemoteObject(), ExamService {



    private val permissionService: PermissionService by di()
    private val databaseService: DatabaseService by di()

    override fun addExam(exam: ExamVo): Id {
        permissionService.checkRole(UserRole.TEACHER)

        databaseService.executeSql("insert $exam")

        return Id()

    }

    override fun getCurrentExam(): ExamVo? {
        return ExamVo(LocalDateTime.now(), Duration.ofHours(2), "考试1", arrayListOf(
            QuestionVo("问题1", arrayListOf("答案1", "答案2"), 0),
            QuestionVo("问题2", arrayListOf("答案1", "答案2"), 1)
        ))
    }

    override fun submitAnswerSheet(answerSheet: AnswerSheetVo): Id {
        databaseService.executeSql("insert $answerSheet")

        return Id()

    }

    override fun getAnswerSheetsOfAnExam(id: Id): List<AnswerSheetVo> {
        return arrayListOf()
    }


}