package nju.classroomassistant.server.database

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.di.ServiceImpl

interface Database {
    fun executeSql(sql: String): String
}

class DatabaseImpl: Database {
    override fun executeSql(sql: String): String {
        return sql
    }
}