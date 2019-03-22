package nju.classroomassistant.server.database

import nju.classroomassistant.server.di.di
import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.di.ServiceImpl

@Service
interface DatabaseCluster {
    val databases: List<Database>

    fun executeSqlOnAll(sql: String): String
}

@ServiceImpl
class DatabaseClusterImpl: DatabaseCluster {

    private val dbLogService: DbLogService by di()


    override val databases: List<Database> = arrayListOf(
        DatabaseImpl(),
        DatabaseImpl(),
        DatabaseImpl(),
        DatabaseImpl()
    )

    override fun executeSqlOnAll(sql: String): String {

        dbLogService.log("Executing SQL: $sql")

        val result = databases.map {
            it.executeSql(sql)
        }

        return result.last()
    }


}
