package nju.classroomassistant.client.app.raisehands

import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.shared.raisehands.RaiseHandsService
import tornadofx.Controller

class StudentRaiseHandsController: Controller() {
    val networkService: NetworkService by di()

    val currentUserManager: CurrentUserManager by di()

    fun raiseHands() {
        networkService.call(RaiseHandsService::class) { service ->
            currentUserManager.withCurrentUser {user ->
                service.raiseHand(user.id)
            }
        }
    }


}