package nju.classroomassistant.shared.filemanagement

interface FileManagementService {
    fun receiveContent(content: String)

    fun getContent(path: String): String?

    fun getAllFilePaths(): List<String>
}