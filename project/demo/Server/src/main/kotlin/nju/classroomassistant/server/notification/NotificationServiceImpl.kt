package nju.classroomassistant.server.notification

import nju.classroomassistant.server.di.di
import nju.classroomassistant.server.network.Export
import nju.classroomassistant.server.permission.PermissionService
import nju.classroomassistant.server.permission.PermissionServiceImpl
import nju.classroomassistant.shared.notification.NotificationService
import nju.classroomassistant.shared.notification.vo.NotificationVo
import nju.classroomassistant.shared.util.Id
import nju.classroomassistant.shared.util.log
import java.rmi.server.UnicastRemoteObject
import java.time.LocalDateTime

@Export
class NotificationServiceImpl: UnicastRemoteObject(), NotificationService {
    private val permissionService: PermissionService by di()

    override fun broadcast(content: String): Id {
        log(this, "推送给所有用户：$content")
        return Id()
    }

    override fun getNotifications(receiverId: Id): List<NotificationVo> {

        // omitting permission check

        val list = mutableListOf<NotificationVo>()

        // insert mock data
        repeat(5) {
            list.add(NotificationVo("通知$it", receiverId, LocalDateTime.now(), Id.ZERO))
        }

        return list

    }
}