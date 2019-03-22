package nju.classroomassistant.server.database

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nju.classroomassistant.server.di.di
import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.di.ServiceImpl
import nju.classroomassistant.shared.util.log

@Service
interface SecurityService {
    fun start()
}

@ServiceImpl
class SecurityServiceImpl : SecurityService {
    private val cluster: DatabaseCluster by di()

    private var started = false

    override fun start() {
        if (started) {
            return
        }

        started = true
        GlobalScope.launch {
            while (true) {
                log(
                    this,
                    "Security check for database cluster consisting of ${cluster.databases.size} databases"
                )
                delay(5000)
            }
        }
    }

}