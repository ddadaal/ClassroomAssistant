package nju.classroomassistant.server.permission

import nju.classroomassistant.shared.di.ServiceImpl
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.model.user.UserVo
import nju.classroomassistant.shared.util.log
import java.lang.RuntimeException

@ServiceImpl
class PermissionServiceImpl: PermissionService {
    override fun checkRole(user: UserVo, vararg expectedRole: UserRole) {
        if (!expectedRole.contains(user.role)) {
            log(this, "Role validation failed.")
        }
    }

}