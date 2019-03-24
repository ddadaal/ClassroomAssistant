package nju.classroomassistant.shared.model.user

import nju.classroomassistant.shared.util.Id
import java.io.Serializable

data class UserVo(
    var id: Id,
    var role: UserRole,
    var `class`: String,
    var username: String
): Serializable {
    constructor(): this(Id.ZERO, UserRole.STUDENT, "", "")
}