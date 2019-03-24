package nju.classroomassistant.shared.util

import java.util.stream.Collectors
import kotlin.reflect.KClass

object RmiHelper {
    val url = "localhost"
    val port = "8888"

    val baseUrl = "rmi://$url:$port/"

    fun generateRmiUrl(interfaceName: String): String {
        return baseUrl + interfaceName

    }

}
