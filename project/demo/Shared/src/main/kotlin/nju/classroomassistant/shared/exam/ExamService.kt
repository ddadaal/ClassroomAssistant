package nju.classroomassistant.shared.exam

import nju.classroomassistant.shared.exam.vo.AnswerSheetVo
import nju.classroomassistant.shared.exam.vo.ExamVo
import nju.classroomassistant.shared.util.Id
import java.rmi.Remote
import java.rmi.RemoteException

interface ExamService: Remote {
    @Throws(RemoteException::class)
    fun addExam(exam: ExamVo): Id

    @Throws(RemoteException::class)
    fun getCurrentExam(): ExamVo?

    @Throws(RemoteException::class)
    fun submitAnswerSheet(answerSheet: AnswerSheetVo): Id

    @Throws(RemoteException::class)
    fun getAnswerSheetsOfAnExam(id: Id): List<AnswerSheetVo>
}