package nju.classroomassistant.client.app.usermanagement

import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.view.login.LoginView
import tornadofx.Controller
import tornadofx.runLater
import java.lang.Exception

class LoginController : Controller() {
    val loginScreen: LoginView by inject()
    val userService: UserService by di()

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
            username == "admin" && password == "secret"
        } ui { successfulLogin ->

            if (successfulLogin) {
                loginScreen.clear()

                if (remember) {
                    with(config) {
                        set(USERNAME to username)
                        set(PASSWORD to password)
                        save()
                    }
                }

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