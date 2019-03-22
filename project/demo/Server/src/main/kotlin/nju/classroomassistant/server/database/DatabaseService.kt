package nju.classroomassistant.server.database

import nju.classroomassistant.shared.di.Service

@Service
interface DatabaseService {
    fun executeSql(sql: String): String
}