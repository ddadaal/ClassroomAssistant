package nju.classroomassistant.client.app.raisehands

import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.shared.raisehands.RaiseHandsService
import nju.classroomassistant.shared.util.Id
import tornadofx.Controller

class TeacherRaiseHandsController: Controller() {
    val networkService: NetworkService by di()

    val currentUserManager: CurrentUserManager by di()


    fun start() {
        networkService.call(RaiseHandsService::class) {
            it.start()
        }
    }

    val people: List<Id>
        get() = networkService.call(RaiseHandsService::class) {
            it.getRaisedPersons()
        }

    fun select(id: Id) {
        networkService.call(RaiseHandsService::class) {
            it.select(id)
        }
    }
}