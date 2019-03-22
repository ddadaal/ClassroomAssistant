package nju.classroomassistant.server.filemanagement

data class File(val path: String, val content: String)

interface FileSystem {
    fun writeFile(path: String, content: String)

    val files: List<File>
}