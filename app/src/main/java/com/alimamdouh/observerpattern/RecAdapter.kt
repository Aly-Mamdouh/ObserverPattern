package com.alimamdouh.observerpattern

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alimamdouh.observerpattern.database.Subscriber
import com.alimamdouh.observerpattern.databinding.CustomLayoutBinding

class RecAdapter(): RecyclerView.Adapter<RecAdapter.CVH>() {

    var lst= emptyList<Product>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVH {
        val bind = CustomLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CVH(bind)
    }

    override fun onBindViewHolder(holder: CVH, position: Int) {
        val models = lst.get(position)
        holder.binding.customTv.text=models.name
    }

    override fun getItemCount(): Int {
        return lst.size
    }

    fun setlist(list: List<Product>) {
        this.lst = list
        notifyDataSetChanged()
    }

    class CVH(val binding: CustomLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}