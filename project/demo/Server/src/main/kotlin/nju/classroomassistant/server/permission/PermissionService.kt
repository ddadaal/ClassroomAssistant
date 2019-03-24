package nju.classroomassistant.server.permission

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.model.user.UserVo

@Service
interface PermissionService {
    fun checkRole(vararg expectedRole: UserRole)
}