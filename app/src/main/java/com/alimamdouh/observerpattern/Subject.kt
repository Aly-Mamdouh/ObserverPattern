package com.alimamdouh.observerpattern

interface Subject {
    fun subscribe(observer: Observer)
    fun unSubscribe(observer: Observer)
    fun notifyAllObservers()
}