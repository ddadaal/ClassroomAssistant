package nju.classroomassistant.server.exam

import nju.classroomassistant.server.network.Export
import nju.classroomassistant.shared.exam.ExamService
import nju.classroomassistant.shared.exam.vo.AnswerSheetVo
import nju.classroomassistant.shared.exam.vo.ExamVo
import java.rmi.server.UnicastRemoteObject

@Export
class ExamServiceImpl: UnicastRemoteObject(), ExamService {
    override fun addExam(exam: ExamVo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun submitAnswerSheet(answerSheet: AnswerSheetVo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}