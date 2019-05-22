package nju.classroomassistant.client.app.checkin

import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.client.view.checkin.StudentCheckinView
import nju.classroomassistant.shared.checkin.CheckinService
import tornadofx.Controller

class StudentCheckinController : Controller() {
    val networkService: NetworkService by di()
    val currentUserManager: CurrentUserManager by di()


    fun checkin() {
        networkService.call(CheckinService::class) { service ->
            currentUserManager.withCurrentUser { user ->
                service.checkin(user.id)
            }
        }


    }

}