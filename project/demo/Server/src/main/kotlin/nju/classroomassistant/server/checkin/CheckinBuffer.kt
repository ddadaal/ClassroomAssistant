package nju.classroomassistant.server.checkin

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.util.Id

@Service
interface CheckinBuffer {
    fun checkin(userId: Id)

    val checkedInStudents: List<Id>
}