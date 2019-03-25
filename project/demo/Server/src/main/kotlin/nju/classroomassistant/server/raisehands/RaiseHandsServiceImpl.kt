package nju.classroomassistant.server.raisehands

import nju.classroomassistant.server.di.di
import nju.classroomassistant.server.network.Export
import nju.classroomassistant.server.permission.PermissionService
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.raisehands.RaiseHandsService
import nju.classroomassistant.shared.util.Id
import nju.classroomassistant.shared.util.log
import java.rmi.server.UnicastRemoteObject

@Export
class RaiseHandsServiceImpl: UnicastRemoteObject(), RaiseHandsService {

    private var queue: RaiseHandsQueue = RaiseHandsQueueImpl()

    private val permissionService: PermissionService by di()

    override fun start() {

        permissionService.checkRole(UserRole.TEACHER)

        // clear current queue
        queue.clear()

        // get another queue
        queue = RaiseHandsQueueImpl()
    }

    override fun getRaisedPersons(): List<Id> {

        permissionService.checkRole(UserRole.TEACHER)

        return ArrayList(queue.currentParticipants)

    }

    override fun raiseHand(id: Id) {
        permissionService.checkRole(UserRole.STUDENT)

        return queue.addParticipant(id)
    }

    override fun select(id: Id) {
        permissionService.checkRole(UserRole.TEACHER)

        log(this, "Selected $id")
    }

}