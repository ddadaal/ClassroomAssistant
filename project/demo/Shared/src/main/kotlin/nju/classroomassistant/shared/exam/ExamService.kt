package nju.classroomassistant.shared.exam

import nju.classroomassistant.shared.exam.vo.AnswerSheetVo
import nju.classroomassistant.shared.exam.vo.ExamVo
import java.rmi.Remote
import java.rmi.RemoteException

interface ExamService: Remote {
    @Throws(RemoteException::class)
    fun addExam(exam: ExamVo)

    @Throws(RemoteException::class)
    fun submitAnswerSheet(answerSheet: AnswerSheetVo)
}