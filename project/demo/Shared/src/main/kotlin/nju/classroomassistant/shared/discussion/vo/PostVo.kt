package nju.classroomassistant.shared.discussion.vo

import nju.classroomassistant.shared.util.Id
import java.io.Serializable

data class PostVo(
    var senderId: Id,
    var content: String
): Serializable