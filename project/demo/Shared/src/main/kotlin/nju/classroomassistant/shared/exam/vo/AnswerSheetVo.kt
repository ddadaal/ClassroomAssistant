package nju.classroomassistant.shared.exam.vo

import nju.classroomassistant.shared.util.Id
import java.io.Serializable
import java.time.LocalDateTime

data class AnswerSheetVo(
    var examId: Id,
    var submitTime: LocalDateTime,
    var userId: Id,
    var answers: List<Int>
): Serializable