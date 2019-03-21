package nju.classroomassistant.shared.exam.vo

import java.io.Serializable
import java.time.Duration
import java.time.LocalDateTime

data class ExamVo(
    var startTime: LocalDateTime,
    var duration: Duration,
    var title: String,
    var questions: List<QuestionVo>
): Serializable
