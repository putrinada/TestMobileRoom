package com.adl.testmobileroom.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_data.view.*

class DataVH (view: View) : RecyclerView.ViewHolder(view) {
   // val edit = view.btnEdit
    val nama = view.txtNamai
    val umur = view.txtUmuri
    val image = view.imageView
    val context = view.context

    fun bindData(adapter:DataAdapter,position: Int) {

        nama.setText(adapter.data.get(position).nama)
        umur.setText(adapter.data.get(position).umur)
        Glide.with(context).load(adapter.data.get(position).photo).into(image)

           // edit.setOnClickListener {
          //  adapter.




       // }

    }


}