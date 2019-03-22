package nju.classroomassistant.server.notification

import nju.classroomassistant.server.database.DatabaseService
import nju.classroomassistant.server.di.di
import nju.classroomassistant.shared.di.ServiceImpl
import nju.classroomassistant.shared.notification.vo.NotificationVo

@ServiceImpl
class NotificationManagementImpl: NotificationManagement {

    private val databaseService: DatabaseService by di()

    private val content = mutableListOf<NotificationVo>()

    override fun add(vo: NotificationVo) {

        content.add(vo)

        // synchronize with database
        databaseService.executeSql("123")
    }

    override val notifications: List<NotificationVo>
        get() = content

}