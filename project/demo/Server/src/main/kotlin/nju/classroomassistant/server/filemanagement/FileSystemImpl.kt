package nju.classroomassistant.server.filemanagement

class FileSystemImpl: FileSystem {
    override fun writeFile(path: String, content: String) {

    }

    override val files: List<File>
        get() = arrayListOf(
            File("/tmp/1.txt", "1.txt content"),
            File("/tmp/2.txt", "2.txt content")
        )

}