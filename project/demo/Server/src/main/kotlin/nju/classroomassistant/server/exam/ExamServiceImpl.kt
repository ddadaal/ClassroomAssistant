package nju.classroomassistant.server.exam

import nju.classroomassistant.server.database.DatabaseService
import nju.classroomassistant.server.di.di
import nju.classroomassistant.server.network.Export
import nju.classroomassistant.server.permission.PermissionService
import nju.classroomassistant.shared.exam.ExamService
import nju.classroomassistant.shared.exam.vo.AnswerSheetVo
import nju.classroomassistant.shared.exam.vo.ExamVo
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.util.Id
import java.rmi.server.UnicastRemoteObject

@Export
class ExamServiceImpl : UnicastRemoteObject(), ExamService {


    private val permissionService: PermissionService by di()
    private val databaseService: DatabaseService by di()

    override fun addExam(exam: ExamVo): Id {
        permissionService.checkRole(UserRole.TEACHER)

        databaseService.executeSql("insert $exam")

        return Id()

    }

    override fun submitAnswerSheet(answerSheet: AnswerSheetVo): Id {
        databaseService.executeSql("insert $answerSheet")

        return Id()

    }

    override fun getAnswerSheetsOfAnExam(id: Id): List<AnswerSheetVo> {
        return arrayListOf()
    }


}