package nju.classroomassistant.shared.discussion

import nju.classroomassistant.shared.discussion.vo.DiscussionVo
import nju.classroomassistant.shared.util.Id
import java.rmi.Remote
import java.rmi.RemoteException

interface DiscussionService: Remote {

    @Throws(RemoteException::class)
    fun getDiscussions(): List<DiscussionVo>

    @Throws(RemoteException::class)
    fun addDiscussion(title: String, description: String = ""): Id

    @Throws(RemoteException::class)
    fun post(discussionId: Id, senderId: Id, content: String)


}