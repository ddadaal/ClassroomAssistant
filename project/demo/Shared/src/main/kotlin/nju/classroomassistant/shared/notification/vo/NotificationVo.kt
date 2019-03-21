package nju.classroomassistant.shared.notification.vo

import nju.classroomassistant.shared.util.Id
import java.io.Serializable
import java.time.LocalDateTime

data class NotificationVo(
    val content: String,
    val receiverId: Id,
    val time: LocalDateTime,
    val senderId: Id
) : Serializable