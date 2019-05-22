package nju.classroomassistant.client.view.filemanagement

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.Alert
import javafx.scene.control.SelectionMode
import javafx.stage.FileChooser
import nju.classroomassistant.client.app.filemanagement.FileManagementController
import nju.classroomassistant.client.app.usermanagement.CurrentUserManager
import nju.classroomassistant.shared.model.user.UserRole
import tornadofx.*


class FileView : View("文件管理") {

    val controller: FileManagementController by inject()
    val currentUserManager: CurrentUserManager by di()

    val files = FXCollections.observableArrayList<String>()
    val selectedFile = SimpleStringProperty()
    val selected = selectedFile.isNotNull

    val isTeacher = SimpleBooleanProperty(false)


    override val root = vbox {
        listview(files) {
            selectionModel.selectionMode = SelectionMode.SINGLE
            bindSelected(selectedFile)
        }
        button("刷新") {
            action {
                updateFiles()
            }
        }
        button("查看内容") {
            enableWhen(selected)
            action {
                val path = selectedFile.get()
                val content = controller.viewOrDownloadFile(path)
                if (content == null) {
                    error("文件不存在！", "文件${path}不存在")
                } else {
                    information("文件内容", content)
                }
            }
        }
        button("下载") {
            enableWhen(selected)
            action {
                val path = selectedFile.get()

                controller.downloadFile(path)

                information("文件下载成功!", "文件${path}已经下载。")
            }
        }
        button("上传") {
            enableWhen(isTeacher)
            action {
                val files = chooseFile("选择上传的文件", arrayOf(), FileChooserMode.Multi)

                controller.uploadFiles(files)

                information("${files.size}个文件上传成功！")
            }
        }
        separator { }
        button("返回") {
            action {
                currentUserManager.backToHome(this@FileView)
            }
        }
    }

    fun updateFiles() {
        controller.updateFiles() ui {
            files.clear()
            files.addAll(it)
        }
    }

    override fun onDock() {
        updateFiles()

        currentUserManager.withCurrentUser {
            isTeacher.set(it.role == UserRole.TEACHER)
        }


    }
}
