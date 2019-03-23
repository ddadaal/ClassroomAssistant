package nju.classroomassistant.server.database.cluster

interface Database {
    fun executeSql(sql: String): String
}

class DatabaseImpl: Database {
    override fun executeSql(sql: String): String {
        return sql
    }
}