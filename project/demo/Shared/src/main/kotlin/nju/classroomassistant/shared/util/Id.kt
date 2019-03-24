package nju.classroomassistant.shared.util

import java.io.Serializable
import java.util.*

class Id(
    var uuid: UUID
) : Serializable {

    constructor() : this(UUID.randomUUID())

    constructor(str: String) : this(UUID.fromString(str))

    fun substring(len: Int): String {
        return uuid.toString().substring(0, len)
    }

    override fun toString(): String {
        return uuid.toString()
    }

    fun short(length: Int = 6) = substring(length)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Id) return false

        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }

    companion object {
        val ZERO = Id(UUID(0, 0))
    }

}