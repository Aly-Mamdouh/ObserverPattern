package com.alimamdouh.observerpattern

import android.util.Log

class Store :Observer {
     var name:String

    constructor(name: String) {
        this.name = name
    }

    override fun update(availbality: String?) {
        Log.i("TAG", "$name have new notification $availbality")
    }

}