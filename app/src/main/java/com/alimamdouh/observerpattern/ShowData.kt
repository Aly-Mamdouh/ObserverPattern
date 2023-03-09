package com.alimamdouh.observerpattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)
        var rv=findViewById<RecyclerView>(R.id.main_rv)
        var back=findViewById<TextView>(R.id.btn_back)
        var intentData=intent.getStringExtra("data")
        rv.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<Product>()
        val list = intentData?.split(" ")
        if (list != null) {
            for(name in list){
                var str="$name Have New Notification "
                data.add(Product(str))
            }
        }
        val adapter = RecAdapter()
        adapter.setlist(data)
        rv.adapter = adapter
        back.setOnClickListener {
            startActivity(Intent(this@ShowData,MainActivity::class.java))
        }
    }
}