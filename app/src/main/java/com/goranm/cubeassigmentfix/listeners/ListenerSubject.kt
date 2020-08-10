package com.goranm.cubeassigmentfix.listeners

interface ListenerSubject {

    fun registerObserver(observer: DataListener)
    fun removeObserver(observer: DataListener)
    fun notifyObserver()

}