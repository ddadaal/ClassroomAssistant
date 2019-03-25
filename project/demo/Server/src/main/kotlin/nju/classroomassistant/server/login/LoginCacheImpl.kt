package nju.classroomassistant.server.login

import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.model.user.UserVo
import nju.classroomassistant.shared.util.Id

class LoginCacheImpl: LoginCache {
    // Username -> UserVo
    private val credentialMap = mutableMapOf<String, UserVo>()

    // Username -> Class
    private val classesMap = mutableMapOf<String, String>()


    init {
        // insert mock data
        credentialMap["teacher"] = UserVo(Id(), UserRole.TEACHER, "1", "teacher")
        credentialMap["student"] = UserVo(Id(), UserRole.STUDENT, "1", "student")
    }

    override fun login(username: String, password: String): UserVo? {
        // No implementation
        return if (username == password) {
            credentialMap[username]
        } else {
            null
        }
    }
}