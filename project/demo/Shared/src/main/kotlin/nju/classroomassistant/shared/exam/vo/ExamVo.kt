package nju.classroomassistant.shared.exam.vo

import nju.classroomassistant.shared.util.Id
import java.io.Serializable
import java.time.Duration
import java.time.LocalDateTime

data class ExamVo(
    var startTime: LocalDateTime,
    var duration: Duration,
    var title: String,
    var questions: List<QuestionVo>
): Serializable {
    val id = Id()
}
