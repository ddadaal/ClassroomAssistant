package nju.classroomassistant.server.raisehands

import nju.classroomassistant.shared.util.Id


interface RaiseHandsQueue {
    fun clear()

    fun addParticipant(userId: Id)

    val currentParticipants: List<Id>
}