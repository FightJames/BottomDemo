package com.example.bottomact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.empty_view.view.*

class DemoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.empty_view, parent, false)
        return EmptyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.content.text = position.toString()
    }
}

class EmptyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}