package nju.classroomassistant.client.app.usermanagement

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.model.user.UserVo
import tornadofx.View

@Service
interface CurrentUserManager {

    fun backToHome(context: View)

    var currentUser: UserVo?

    fun checkLogin(): Boolean
}