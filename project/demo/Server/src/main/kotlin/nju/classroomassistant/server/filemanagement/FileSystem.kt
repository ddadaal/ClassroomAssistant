package nju.classroomassistant.server.filemanagement

import nju.classroomassistant.shared.di.Service

data class File(val path: String, val content: String)

@Service
interface FileSystem {
    fun writeFile(path: String, content: String)

    val files: List<File>
}