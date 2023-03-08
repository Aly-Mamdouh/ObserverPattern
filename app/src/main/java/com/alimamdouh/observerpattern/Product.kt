package com.alimamdouh.observerpattern

import android.util.Log

class Product : Subject {
    private var name: String
    private var availbality: String="state"
    private var lst: MutableList<Observer> = mutableListOf()

    constructor(name: String) {
        this.name = name
    }

    override fun subscribe(observer: Observer) {
        lst.add(observer)
    }

    override fun unSubscribe(observer: Observer) {
        var obs:Observer?=null
       lst.forEach {
           if((observer as Store).name==(it as Store).name){
               obs=it
           }
       }
        lst.remove(obs)
    }

    override fun notifyAllObservers() {
        for (observer in lst) {
            observer.update(availbality)
        }
    }

    fun setAvailbality(availibale: Boolean) {
        availbality = this.name + if (availibale) " Available" else " Not Available"
        notifyAllObservers()
    }
    fun getAllObservers():MutableList<Observer>{
        return lst
    }
}