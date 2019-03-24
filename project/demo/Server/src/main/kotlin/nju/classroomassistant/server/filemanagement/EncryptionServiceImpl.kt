package nju.classroomassistant.server.filemanagement

import nju.classroomassistant.shared.di.ServiceImpl

@ServiceImpl
class EncryptionServiceImpl: EncryptionService {
    override fun encrypt(content: String): String {
        return content
    }

    override fun decrypt(encrypted: String): String {
        return encrypted
    }

}