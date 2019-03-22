package nju.classroomassistant.server.checkin

import nju.classroomassistant.server.di.di
import nju.classroomassistant.server.network.Export
import nju.classroomassistant.server.permission.PermissionService
import nju.classroomassistant.server.permission.PermissionServiceImpl
import nju.classroomassistant.shared.checkin.CheckinService
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.model.user.UserVo
import java.rmi.server.UnicastRemoteObject

@Export
class CheckinServiceImpl : UnicastRemoteObject(), CheckinService {

    private val cache: CheckinCache by di()
    private val permissionService: PermissionService by di()

    override fun checkin(user: UserVo) {

        permissionService.checkRole(user, UserRole.TEACHER, UserRole.STUDENT)

        cache.checkin(user.id)
    }


}
