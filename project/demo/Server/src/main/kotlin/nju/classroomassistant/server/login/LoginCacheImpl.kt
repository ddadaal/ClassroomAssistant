package nju.classroomassistant.server.login

import nju.classroomassistant.shared.di.ServiceImpl
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.model.user.UserVo
import nju.classroomassistant.shared.util.Id

@ServiceImpl
class LoginCacheImpl: LoginCache {
    // Username -> UserVo
    private val cache = mutableMapOf<String, UserVo>()

    // Username -> Class
    private val classes = mutableMapOf<String, String>()


    init {
        // insert mock data
        cache["teacher"] = UserVo(Id(), UserRole.TEACHER, "1", "teacher")
        cache["student"] = UserVo(Id(), UserRole.STUDENT, "1", "student")
    }

    override fun login(username: String, password: String): UserVo? {
        // No implementation
        return if (username == password) {
            cache[username]
        } else {
            null
        }
    }
}