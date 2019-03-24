package nju.classroomassistant.shared.raisehands

import nju.classroomassistant.shared.util.Id
import java.rmi.Remote
import java.rmi.RemoteException

interface RaiseHandsService: Remote {

    @Throws(RemoteException::class)
    fun start()

    @Throws(RemoteException::class)
    fun getRaisedPersons(): List<Id>

    @Throws(RemoteException::class)
    fun raiseHand(id: Id)

    @Throws(RemoteException::class)
    fun select(id: Id)
}