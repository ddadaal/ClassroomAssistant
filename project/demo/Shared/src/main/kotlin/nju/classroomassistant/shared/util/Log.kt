package nju.classroomassistant.shared.util

fun log(sender: Any, content: String) {
    println("[${sender::class.simpleName}] $content")
}