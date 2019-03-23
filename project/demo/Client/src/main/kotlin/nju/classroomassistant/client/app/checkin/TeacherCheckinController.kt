package nju.classroomassistant.client.app.checkin

import javafx.concurrent.Task
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.view.checkin.TeacherCheckinView
import nju.classroomassistant.shared.checkin.CheckinService
import nju.classroomassistant.shared.util.Id
import tornadofx.Controller
import tornadofx.FXTask

class TeacherCheckinController: Controller() {

    val networkService: NetworkService by di()

    fun update(): Task<List<Id>> {
        return runAsync {
            networkService.call(CheckinService::class) {
                it.getCheckedinStudent()
            }
        }
    }

}