package nju.classroomassistant.shared.filemanagement

import java.rmi.Remote
import java.rmi.RemoteException

interface FileManagementService: Remote {
    @Throws(RemoteException::class)
    fun receiveContent(content: String)

    @Throws(RemoteException::class)
    fun getContent(path: String): String?

    @Throws(RemoteException::class)
    fun getAllFilePaths(): List<String>
}