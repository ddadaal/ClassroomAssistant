package nju.classroomassistant.server.notification

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.notification.vo.NotificationVo

@Service
interface NotificationManagement {
    fun add(vo: NotificationVo)

    val notifications: List<NotificationVo>
}