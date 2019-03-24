package nju.classroomassistant.client.view.login

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.util.Duration
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.LoginController
import nju.classroomassistant.client.view.login.Styles.Companion.loginView
import nju.classroomassistant.shared.util.log
import tornadofx.*
import java.lang.Exception

class LoginView : View("登录") {
    val loginController: LoginController by inject()
    val networkService: NetworkService by di()


    private val model = object : ViewModel() {
        val username = bind { SimpleStringProperty() }
        val password = bind { SimpleStringProperty() }
        val remember = bind { SimpleBooleanProperty() }
    }

    override val root = form {
        addClass(loginView)
        fieldset {
            field("Username") {
                textfield(model.username) {
                    required()
                    whenDocked { requestFocus() }
                }
            }
            field("Password") {
                passwordfield(model.password).required()
            }
            field("Remember me") {
                checkbox(property = model.remember)
            }
        }

        button("Login") {
            isDefaultButton = true

            action {
                model.commit {
                    loginController.tryLogin(
                        model.username.value,
                        model.password.value,
                        model.remember.value
                    )
                }
            }
        }
    }

    override fun onDock() {

            networkService.connect()

        model.validate(decorateErrors = false)
    }

    fun shakeStage() {
        var x = 0
        var y = 0
        val cycleCount = 10
        val move = 10
        val keyframeDuration = Duration.seconds(0.04)

        val stage = FX.primaryStage

        val timelineX = Timeline(KeyFrame(keyframeDuration, EventHandler {
            if (x == 0) {
                stage.x = stage.x + move
                x = 1
            } else {
                stage.x = stage.x - move
                x = 0
            }
        }))

        timelineX.cycleCount = cycleCount
        timelineX.isAutoReverse = false

        val timelineY = Timeline(KeyFrame(keyframeDuration, EventHandler {
            if (y == 0) {
                stage.y = stage.y + move
                y = 1
            } else {
                stage.y = stage.y - move
                y = 0
            }
        }))

        timelineY.cycleCount = cycleCount
        timelineY.isAutoReverse = false

        timelineX.play()
        timelineY.play()
    }

    fun clear() {
        model.username.value = ""
        model.password.value = ""
        model.remember.value = false
    }
}