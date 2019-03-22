package nju.classroomassistant.shared.util

fun log(sender: Any, content: String) {
    println("[${if (sender is String) { sender } else { sender::class.simpleName}}] $content")
}