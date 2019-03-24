package nju.classroomassistant.server.database.dblog

import nju.classroomassistant.server.database.cloudbackup.CloudBackupService
import nju.classroomassistant.server.di.di
import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.di.ServiceImpl

@Service
interface DbLogService {
    fun log(content: String)
}

@ServiceImpl
class DbLogServiceImpl: DbLogService {

    private val cloudBackupService: CloudBackupService by di()

    override fun log(content: String) {
        nju.classroomassistant.shared.util.log(this, "Write database log: $content")

        cloudBackupService.backup("DB log: $content")
    }

}