package nju.classroomassistant.client.app.discussion

import javafx.concurrent.Task
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.shared.discussion.DiscussionService
import nju.classroomassistant.shared.discussion.vo.DiscussionVo
import nju.classroomassistant.shared.util.Id
import tornadofx.Controller

class TeacherDiscussionController: Controller() {
    val networkService: NetworkService by di()
    private val currentUserManager: CurrentUserManager by di()

    fun startDiscussion(title: String): Task<Id> {
        return runAsync {
            networkService.call(DiscussionService::class) {
                it.startDiscussion(title)
            }
        }
    }

    fun getCurrentDiscussion(): Task<DiscussionVo> {
        return runAsync {
            networkService.call(DiscussionService::class) {
                it.getCurrentDiscussion()
            }
        }
    }
}