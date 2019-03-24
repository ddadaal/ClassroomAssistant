package nju.classroomassistant.client.app.usermanagement

import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.view.login.LoginView
import nju.classroomassistant.client.view.main.StudentMainView
import nju.classroomassistant.client.view.main.TeacherMainView
import nju.classroomassistant.shared.login.LoginService
import nju.classroomassistant.shared.model.user.UserRole
import tornadofx.Controller
import tornadofx.runLater

class LoginController : Controller() {
    val loginScreen: LoginView by inject()
    val currentUserManager: CurrentUserManager by di()
    val networkService: NetworkService by di()


    fun init() {

        with(config) {
            if (containsKey(USERNAME) && containsKey(PASSWORD))
                tryLogin(string(USERNAME), string(PASSWORD), true)
            else
                showLoginScreen("Please log in")
        }
    }

    fun showLoginScreen(message: String, shake: Boolean = false) {
        runLater {
            if (shake) loginScreen.shakeStage()
        }
    }

    fun tryLogin(username: String, password: String, remember: Boolean) {
        runAsync {
            currentUserManager.currentUser = networkService.call(LoginService::class) { it.login(username, password) }
            currentUserManager.currentUser
        } ui { user ->

            if (user != null) {

                if (remember) {
                    with(config) {
                        set(USERNAME to username)
                        set(PASSWORD to password)
                        save()
                    }
                }

                loginScreen.replaceWith(when (user.role) {
                    UserRole.TEACHER -> TeacherMainView::class
                    UserRole.STUDENT -> StudentMainView::class
                }, sizeToScene = true)


            } else {
                showLoginScreen("Login failed. Please try again.", true)
            }
        }
    }

    fun logout() {
        with(config) {
            remove(USERNAME)
            remove(PASSWORD)
            save()
        }

        showLoginScreen("Log in as another user")
    }

    companion object {
        val USERNAME = "username"
        val PASSWORD = "password"
    }

}