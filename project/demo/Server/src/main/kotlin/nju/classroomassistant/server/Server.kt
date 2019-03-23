package nju.classroomassistant.server

import nju.classroomassistant.server.network.exportServices
import nju.classroomassistant.shared.util.log

fun main() {
    exportServices()

    log("Main", "Server initialized.")
}