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

    override var currentUser: UserVo? = null
}