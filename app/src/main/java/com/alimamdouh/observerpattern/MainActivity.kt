package com.alimamdouh.observerpattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var customer: Customer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var subsName = findViewById<EditText>(R.id.subscribe_name)
        var btn_subs = findViewById<Button>(R.id.btn_subs)
        var btn_unSubs = findViewById<Button>(R.id.btn_unSubs)
        var btn_show = findViewById<Button>(R.id.display_subscriber)
        var add_product = findViewById<Button>(R.id.add_pro)
        var product_name = findViewById<EditText>(R.id.pro_name)

        var store=Store()
        add_product.setOnClickListener {
            var productName= product_name.text.toString()
            var pro = Product(productName)
            store.addProduct(pro)
        }


        var str = StringBuilder()
        var data: String = ""
        var lst: MutableList<Observer> = store.getAllObservers()
        var intent = Intent()

        btn_subs.setOnClickListener {
            var name = subsName.text.toString()
            customer = Customer(name)
            store.subscribe(customer)
            store.setAvailbality(true)
            lst = store.getAllObservers()
            lst.forEach {
                str.append((it as Customer).name).append(" ")
            }
            data = str.toString()
            str.clear()
        }
        btn_unSubs.setOnClickListener {
            var name = subsName.text.toString()
            customer = Customer(name)
            store.unSubscribe(customer)
            store.setAvailbality(false)
            lst = store.getAllObservers()
            lst.forEach {
                str.append((it as Customer).name).append(" ")
            }
            data = str.toString()
            str.clear()
        }

        btn_show.setOnClickListener {
            val intent = Intent(this@MainActivity, ShowData::class.java);
            intent.putExtra("data", data)
            startActivity(intent);
        }

    }
}