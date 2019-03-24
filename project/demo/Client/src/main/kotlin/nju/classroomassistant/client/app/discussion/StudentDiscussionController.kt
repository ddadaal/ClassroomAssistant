package nju.classroomassistant.client.app.discussion

import javafx.concurrent.Task
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.shared.discussion.DiscussionService
import tornadofx.Controller

class StudentDiscussionController : Controller() {
    val networkService: NetworkService by di()
    val currentUserManager: CurrentUserManager by di()

    fun send(content: String) {
        networkService.call(DiscussionService::class) {
            it.post(currentUserManager.currentUser!!.id, content)
        }
    }

    fun getCurrentQuestion(): Task<String> {
        return runAsync {
            networkService.call(DiscussionService::class) {
                it.getCurrentDiscussion().title
            }
        }
    }
}