package nju.classroomassistant.client.app.usermanagement

import nju.classroomassistant.client.app.di.ServiceImpl
import nju.classroomassistant.shared.model.user.User

@ServiceImpl
class UserServiceImpl: UserService {
    override fun checkLogin(): Boolean {
        return currentUser != null
    }

    override var currentUser: User? = null
}