package nju.classroomassistant.client.app.filemanagement

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.di.ServiceImpl


@Service
interface FileSystem {
    fun writeFile(path: String, content: String)

    val files: MutableMap<String, String>
}

@ServiceImpl
class FileSystemImpl: FileSystem {

    override val files = mutableMapOf<String, String>()

    override fun writeFile(path: String, content: String) {
        files[path] = content
    }

}