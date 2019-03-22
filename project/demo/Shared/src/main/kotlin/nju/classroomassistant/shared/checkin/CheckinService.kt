package nju.classroomassistant.shared.checkin

import nju.classroomassistant.shared.model.user.UserVo
import java.rmi.Remote
import java.rmi.RemoteException

interface CheckinService: Remote {

    @Throws(RemoteException::class)
    fun checkin(user: UserVo)
}