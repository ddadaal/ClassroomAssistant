package nju.classroomassistant.client.app.usermanagement

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.model.user.UserVo
import tornadofx.View

@Service
interface CurrentUserManager {

    fun backToHome(context: View)

    fun <T> withCurrentUser(handle: (user: UserVo) -> T): T

    fun checkLogin(): Boolean

    fun setCurrentUser(user: UserVo?)
}