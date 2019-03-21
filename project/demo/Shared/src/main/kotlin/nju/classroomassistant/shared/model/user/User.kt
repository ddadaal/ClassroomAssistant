package nju.classroomassistant.shared.model.user

import nju.classroomassistant.shared.util.Id
import java.io.Serializable

data class User(
    var id: Id,
    var role: UserRole
): Serializable {
    constructor(): this(Id.ZERO, UserRole.STUDENT)
}