package nju.classroomassistant.server.filemanagement

import nju.classroomassistant.shared.di.Service
import nju.classroomassistant.shared.di.ServiceImpl

@Service
interface EncryptionService {
    fun encrypt(content: String): String

    fun decrypt(encrypted: String): String
}

