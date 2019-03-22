package nju.classroomassistant.server.raisehands

import nju.classroomassistant.server.database.DatabaseService
import nju.classroomassistant.server.di.di
import nju.classroomassistant.shared.util.Id
import java.util.concurrent.ConcurrentLinkedQueue

class RaiseHandsQueueImpl: RaiseHandsQueue {

    private val queue = ConcurrentLinkedQueue<Id>()
    private val databaseService: DatabaseService by di()

    override fun clear() {
        // insert all remaining data into the database
        while (queue.isNotEmpty()) {
            val id = queue.poll()
            databaseService.executeSql("insert into ...")
        }
    }

    override fun addParticipant(userId: Id) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val currentParticipants: List<Id>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

}