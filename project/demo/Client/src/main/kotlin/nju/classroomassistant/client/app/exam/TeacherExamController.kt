package nju.classroomassistant.client.app.exam

import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import tornadofx.Controller

class TeacherExamController: Controller() {
    val networkService: NetworkService by di()
    private val currentUserManager: CurrentUserManager by di()


}