package nju.classroomassistant.client.app.usermanagement

import nju.classroomassistant.client.app.di.Service
import nju.classroomassistant.shared.model.user.User

@Service
interface UserService {
    val currentUser: User?

    fun checkLogin(): Boolean
}