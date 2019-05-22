package nju.classroomassistant.client.app.usermanagement

import nju.classroomassistant.client.view.main.StudentMainView
import nju.classroomassistant.client.view.main.TeacherMainView
import nju.classroomassistant.shared.di.ServiceImpl
import nju.classroomassistant.shared.model.user.UserRole
import nju.classroomassistant.shared.model.user.UserVo
import tornadofx.View

@ServiceImpl
class CurrentUserManagerImpl : CurrentUserManager {

    override fun backToHome(context: View) {
        val isTeacher = currentUser?.role == UserRole.TEACHER

        context.replaceWith(
            if (isTeacher)
                TeacherMainView::class
            else
                StudentMainView::class,
            sizeToScene = true
        )
    }

    override fun checkLogin(): Boolean {
        return currentUser != null
    }

    private var currentUser: UserVo? = null

    override fun setCurrentUser(user: UserVo?) {
        this.currentUser = user
    }


    override fun <T> withCurrentUser(handle: (user: UserVo) -> T): T {
        if (currentUser != null) {
            return handle(currentUser!!)
        } else {
            throw Exception()
        }
    }
}