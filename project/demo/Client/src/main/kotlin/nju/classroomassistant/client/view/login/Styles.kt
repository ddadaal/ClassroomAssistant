package nju.classroomassistant.client.view.login

import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val loginView by cssclass()
    }

    init {
        loginView {
            padding = box(15.px)
            vgap = 7.px
            hgap = 10.px
        }
    }
}