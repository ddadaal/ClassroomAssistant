package nju.classroomassistant.shared.discussion

import nju.classroomassistant.shared.discussion.vo.DiscussionVo
import nju.classroomassistant.shared.util.Id
import java.rmi.Remote
import java.rmi.RemoteException

interface DiscussionService: Remote {

    @Throws(RemoteException::class)
    fun startDiscussion(title: String): Id

    @Throws(RemoteException::class)
    fun post(senderId: Id, content: String)

    @Throws(RemoteException::class)
    fun getCurrentDiscussion(): DiscussionVo
}