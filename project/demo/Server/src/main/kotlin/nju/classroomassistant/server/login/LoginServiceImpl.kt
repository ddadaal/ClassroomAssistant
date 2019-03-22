package nju.classroomassistant.server.login

import nju.classroomassistant.server.di.di
import nju.classroomassistant.server.network.Export
import nju.classroomassistant.shared.login.LoginService
import nju.classroomassistant.shared.model.user.UserVo
import nju.classroomassistant.shared.util.log
import java.rmi.server.UnicastRemoteObject

@Export
class LoginServiceImpl: UnicastRemoteObject(), LoginService {

    private val cache: LoginCache by di()

    override fun login(username: String, password: String): UserVo? {
        log(this, "Attempting to login with $username and $password")
        return cache.login(username, password)
    }

}