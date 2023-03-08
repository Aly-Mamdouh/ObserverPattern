package com.alimamdouh.observerpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var store: Store
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var subsName = findViewById<EditText>(R.id.subscribe_name)
        var btn_subs = findViewById<Button>(R.id.btn_subs)
        var btn_unSubs = findViewById<Button>(R.id.btn_unSubs)
        var tv_all = findViewById<TextView>(R.id.tv_all)
        var product = Product("iphone")
        var str=StringBuilder()
        var lst:MutableList<Observer> = product.getAllObservers()

        btn_subs.setOnClickListener {
            store = Store(subsName.text.toString())
            product.subscribe(store)
            product.setAvailbality(true)
            lst=product.getAllObservers()
            lst.forEach {
                str.append((it as Store).name).append(" ")
            }
            tv_all.text=str
            str.clear()
        }
        btn_unSubs.setOnClickListener {
            store = Store(subsName.text.toString())
            product.unSubscribe(store)
            product.setAvailbality(false)
            lst=product.getAllObservers()
            lst.forEach {
                str.append((it as Store).name).append(" ")
            }
            tv_all.text=str
            str.clear()
        }



    }
}