package nju.classroomassistant.shared.login

import nju.classroomassistant.shared.model.user.User
import java.rmi.Remote
import java.rmi.RemoteException

interface LoginService: Remote {

    @Throws(RemoteException::class)
    fun login(username: String, password: String): User
}