package nju.classroomassistant.server.notification

import nju.classroomassistant.server.network.Export
import nju.classroomassistant.shared.notification.NotificationService
import nju.classroomassistant.shared.notification.vo.NotificationVo
import nju.classroomassistant.shared.util.Id
import java.rmi.server.UnicastRemoteObject

@Export
class NotificationServiceImpl: UnicastRemoteObject(), NotificationService {
    override fun broadcast(content: String): Id {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNotifications(receiverId: Id): List<NotificationVo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}