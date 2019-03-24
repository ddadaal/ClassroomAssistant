package nju.classroomassistant.server.database.cloudbackup

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.di.ServiceImpl
import nju.classroomassistant.shared.util.Id

@Service
interface CloudBackupService {
    fun backup(content: String): Id

    fun retrieve(id: Id): String?
}

@ServiceImpl
class CloudBackupServiceImpl: CloudBackupService {

    private val data = mutableMapOf<Id, String>()

    override fun backup(content: String): Id {
        val id = Id()
        data[id] = content

        return id
    }

    override fun retrieve(id: Id): String? {
        return data[id]
    }

}