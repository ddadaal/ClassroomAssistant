package nju.classroomassistant.client.view

import nju.classroomassistant.client.app.Styles
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
        label("another content")
    }
}