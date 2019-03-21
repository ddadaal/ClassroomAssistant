package nju.classroomassistant.shared.notification

import nju.classroomassistant.shared.notification.vo.NotificationVo
import nju.classroomassistant.shared.util.Id
import java.rmi.Remote
import java.rmi.RemoteException

interface NotificationService: Remote {

    @Throws(RemoteException::class)
    fun broadcast(content: String): Id

    @Throws(RemoteException::class)
    fun getNotifications(receiverId: Id): List<NotificationVo>
}