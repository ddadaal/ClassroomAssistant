package nju.classroomassistant.server.notification

import nju.classroomassistant.server.di.di
import nju.classroomassistant.server.network.Export
import nju.classroomassistant.server.permission.PermissionService
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.notification.NotificationService
import nju.classroomassistant.shared.notification.vo.NotificationVo
import nju.classroomassistant.shared.util.Id
import nju.classroomassistant.shared.util.log
import java.rmi.server.UnicastRemoteObject
import java.time.LocalDateTime

@Export
class NotificationServiceImpl: UnicastRemoteObject(), NotificationService {
    private val permissionService: PermissionService by di()
    private val management: NotificationManagement by di()

    init {
        repeat(5) {
            addNotification("通知测试$it")
        }
    }

    override fun addNotification(content: String): Id {

        permissionService.checkRole(UserRole.TEACHER)

        // add a notification
        log(this, "Add a notification $content")

        val time = LocalDateTime.now()
        val notification = NotificationVo(content, Id.ZERO, time, Id.ZERO)
        management.add(notification)
        return notification.id
    }

    override fun getNotifications(receiverId: Id): List<NotificationVo> {

        // omitting permission check

        return management.notifications.filter {
            it.receiverId == receiverId || it.receiverId == Id.ZERO
        }
    }
}