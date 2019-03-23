package nju.classroomassistant.client.view.raisehands

import nju.classroomassistant.client.app.raisehands.StudentRaiseHandsController
import tornadofx.*

class StudentRaiseHandsView : View("My View") {

    val controller: StudentRaiseHandsController by inject()

    override val root = vbox {
        button("举手！") {
            action {
                controller.raiseHands()
                information("举手成功", "举手成功！")
            }
        }
    }
}
