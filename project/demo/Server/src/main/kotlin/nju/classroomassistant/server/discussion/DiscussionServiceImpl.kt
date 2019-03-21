package nju.classroomassistant.server.discussion

import nju.classroomassistant.server.network.Export
import nju.classroomassistant.shared.discussion.DiscussionService
import nju.classroomassistant.shared.discussion.vo.DiscussionVo
import nju.classroomassistant.shared.util.Id
import java.rmi.server.UnicastRemoteObject

@Export
class DiscussionServiceImpl: UnicastRemoteObject(), DiscussionService {
    override fun getDiscussions(): List<DiscussionVo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addDiscussion(title: String, description: String): Id {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun post(discussionId: Id, senderId: Id, content: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}