package nju.classroomassistant.shared.checkin

import nju.classroomassistant.shared.model.user.UserVo
import nju.classroomassistant.shared.util.Id
import java.rmi.Remote
import java.rmi.RemoteException

interface CheckinService: Remote {

    @Throws(RemoteException::class)
    fun checkin(userId: Id)

    @Throws(RemoteException::class)
    fun getCheckedInStudents(): List<Id>
}