package nju.classroomassistant.server.filemanagement

import nju.classroomassistant.server.di.di
import nju.classroomassistant.server.network.Export
import nju.classroomassistant.server.permission.PermissionService
import nju.classroomassistant.shared.filemanagement.FileManagementService
import nju.classroomassistant.shared.model.user.UserRole
import java.rmi.server.UnicastRemoteObject
import kotlin.random.Random

@Export
class FileManagementServiceImpl: UnicastRemoteObject(), FileManagementService {

    private val encryptionService: EncryptionService by di()
    private val fileSystem: FileSystem by di()
    private val permissionService: PermissionService by di()

    override fun getAllFilePaths(): List<String> {
        return fileSystem.files.map { it.path }
    }

    override fun receiveContent(content: String) {

        permissionService.checkRole(UserRole.TEACHER)

        val encryptedContent = encryptionService.encrypt(content)
        val path = "/tmp/${Random.nextInt()}"
        fileSystem.writeFile(path, encryptedContent)
    }

    override fun getContent(path: String): String? {

        val file = fileSystem.files.find { it.path == path } ?: return null

        return encryptionService.decrypt(file.content)

    }

}