package nju.classroomassistant.client.app.filemanagement

import javafx.concurrent.Task
import nju.classroomassistant.client.app.network.NetworkService
import nju.classroomassistant.client.view.filemanagement.FileView
import nju.classroomassistant.shared.filemanagement.FileManagementService
import tornadofx.Controller
import java.io.File

class FileManagementController : Controller() {


    private val networkService: NetworkService by di()

    private val fileSystem: FileSystem by di()


    fun updateFiles(): Task<List<String>> {
        return runAsync {
            networkService.call(FileManagementService::class) {
                it.getAllFilePaths()
            }
        }
    }

    fun viewOrDownloadFile(path: String): String? {
        if (!fileSystem.files.containsKey(path)) {
            downloadFile(path)
        }
        return fileSystem.files[path]
    }

    fun downloadFile(path: String) {

        val content = networkService.call(FileManagementService::class) {
            it.getContent(path)
        } ?: return

        fileSystem.writeFile(path, content)


    }

    fun uploadFiles(files: List<File>) {
        networkService.call(FileManagementService::class) { service ->
            files.forEach { file ->
                service.receiveContent(file.readText())
            }
        }
    }
}