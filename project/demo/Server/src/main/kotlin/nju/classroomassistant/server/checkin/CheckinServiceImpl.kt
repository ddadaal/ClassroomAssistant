package nju.classroomassistant.server.checkin

import nju.classroomassistant.server.network.Export
import nju.classroomassistant.shared.checkin.CheckinService
import nju.classroomassistant.shared.model.user.User
import java.rmi.server.UnicastRemoteObject

@Export
class CheckinServiceImpl : UnicastRemoteObject(), CheckinService {
    override fun checkin(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
