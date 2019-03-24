package nju.classroomassistant.server.notification

import nju.classroomassistant.server.database.DatabaseService
import nju.classroomassistant.server.di.di
import nju.classroomassistant.shared.di.ServiceImpl
import nju.classroomassistant.shared.notification.vo.NotificationVo
import nju.classroomassistant.shared.util.Id
import java.time.LocalDateTime

@ServiceImpl
class NotificationManagementImpl: NotificationManagement {


    private val databaseService: DatabaseService by di()

    private val content = mutableListOf<NotificationVo>()

    init {
        repeat(5) { i ->
            content.add(NotificationVo("通知测试$i", Id.ZERO, LocalDateTime.now(), Id.ZERO))
        }
    }


    override fun add(vo: NotificationVo) {

        content.add(vo)

        // synchronize with database
        databaseService.executeSql("123")
    }

    override val notifications: List<NotificationVo>
        get() = content

}