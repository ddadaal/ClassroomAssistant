package nju.classroomassistant.server.login

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.model.user.UserVo
import nju.classroomassistant.shared.util.Id

@Service
interface LoginCache {
    fun login(username: String, password: String): UserVo?
}