package nju.classroomassistant.shared.discussion.vo

import nju.classroomassistant.shared.util.Id
import java.io.Serializable

class DiscussionVo(
    var id: Id,
    var title: String,
    var posts: List<PostVo> = ArrayList()
): Serializable {

    constructor(): this(Id.ZERO,"")


}