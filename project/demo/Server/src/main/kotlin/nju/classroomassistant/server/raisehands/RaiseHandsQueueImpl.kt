package nju.classroomassistant.server.raisehands

import nju.classroomassistant.server.database.DatabaseService
import nju.classroomassistant.server.di.di
import nju.classroomassistant.shared.util.Id
import java.util.concurrent.ConcurrentLinkedQueue

class RaiseHandsQueueImpl: RaiseHandsQueue {

    private val queue = ConcurrentLinkedQueue<Id>()
    private val databaseService: DatabaseService by di()


    init {
        queue.add(Id())
        queue.add(Id())
    }

    override fun clear() {
        // insert all remaining data into the database
        while (queue.isNotEmpty()) {
            val id = queue.poll()
            databaseService.executeSql("insert into ...")
        }
    }

    override fun addParticipant(userId: Id) {
        queue.add(userId)

        if (queue.size > 10) {
            clear()
        }
    }

    override val currentParticipants: List<Id>
        get() = queue.toList()

}