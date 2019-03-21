package nju.classroomassistant.shared.exam.vo

import java.io.Serializable

data class QuestionVo(
    var description: String,
    var candidateAnswers: List<String>,
    var correctAnswerIndex: Int
): Serializable
