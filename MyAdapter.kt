package com.example.navdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.navdemo.databinding.ListItemsBinding

class MyAdapter(var dobs: ArrayList<Birthday>) : RecyclerView.Adapter<MyAdapter.MyView>() {
    class MyView(val view: View):RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tname)
        val dob = view.findViewById<TextView>(R.id.tdob)
        val bg = view.findViewById<TextView>(R.id.tbg)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var layout =LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)
        return MyView(layout)
    }
    override fun onBindViewHolder(holder: MyView, position: Int) {

            holder.name.text = dobs[position].name
            holder.dob.setText(dobs[position].dob.toString())
            holder.bg.setText(dobs[position].bg)

    }

    override fun getItemCount(): Int {
        return dobs.size
    }

    fun filterList(updateList: ArrayList<Birthday>) {
        dobs = dobs
        notifyDataSetChanged()
    }



}
