package nju.classroomassistant.server.checkin

import nju.classroomassistant.server.di.di
import nju.classroomassistant.server.network.Export
import nju.classroomassistant.server.permission.PermissionService
import nju.classroomassistant.shared.checkin.CheckinService
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.model.user.UserVo
import nju.classroomassistant.shared.util.Id
import java.rmi.server.UnicastRemoteObject

@Export
class CheckinServiceImpl : UnicastRemoteObject(), CheckinService {


    private val buffer = CheckinBufferImpl()
    private val permissionService: PermissionService by di()

    override fun checkin(userId: Id) {

        permissionService.checkRole(UserRole.TEACHER, UserRole.STUDENT)

        buffer.checkin(userId)
    }

    override fun getCheckedInStudents(): List<Id> {
        return buffer.checkedInStudents
    }

}
