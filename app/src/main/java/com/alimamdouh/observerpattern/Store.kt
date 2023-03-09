package com.alimamdouh.observerpattern

class Store : Subject {
    private var pro: Product=Product("product")
    private var availbality: String="state"
    private var lst: MutableList<Observer> = mutableListOf()


    override fun subscribe(observer: Observer) {
        lst.add(observer)
    }

    override fun unSubscribe(observer: Observer) {
        var obs:Observer?=null
       lst.forEach {
           if((observer as Customer).name==(it as Customer).name){
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
        availbality = this.pro.name + if (availibale) " Available" else " Not Available"
        notifyAllObservers()
    }
    fun getAllObservers():MutableList<Observer>{
        return lst
    }
    fun addProduct(product: Product){
        this.pro=product
    }
}