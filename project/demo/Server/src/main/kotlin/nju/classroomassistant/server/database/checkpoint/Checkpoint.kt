package nju.classroomassistant.server.database.checkpoint

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nju.classroomassistant.server.database.cloudbackup.CloudBackupService
import nju.classroomassistant.server.database.cluster.DatabaseCluster
import nju.classroomassistant.server.di.di
import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.di.ServiceImpl
import nju.classroomassistant.shared.util.Id
import nju.classroomassistant.shared.util.log
import java.time.LocalDateTime

@Service
interface CheckpointService {
    fun start()

    val checkpoints: List<String>

    fun getCheckpoint(time: String): Id?
}

@ServiceImpl
class CheckpointServiceImpl: CheckpointService {

    private val cloudBackupService: CloudBackupService by di()

    private val cluster: DatabaseCluster by di()

    private var started = false

    private val cpMap = mutableMapOf<String, Id>()

    override val checkpoints: List<String>
        get() = cpMap.keys.toList()

    override fun getCheckpoint(time: String): Id? {
        return cpMap[time]
    }


    override fun start() {
        if (started) { return }

        GlobalScope.launch {
            while (true) {
                log(
                    this,
                    "Database checkpoint. Backing up data."
                )

                val data= cluster.databases.first().executeSql("select * from *")

                val cloudDataId = cloudBackupService.backup(data)

                val time = LocalDateTime.now().toString()

                cpMap[time] = cloudDataId

                log(
                    this,
                    "Checkpoint complete. Time: $time; Cloud data id: ${cloudDataId.short()}$"
                )

                delay(5000)
            }
        }

    }

}