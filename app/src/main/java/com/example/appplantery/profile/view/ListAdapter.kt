package com.example.appplantery.profile.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appplantery.R

class ListAdapter(private val mainItems: List<ListItem>) : RecyclerView.Adapter<ListAdapter.ListProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListProfileViewHolder {
        return ListProfileViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_itens_menu, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListProfileViewHolder, position: Int) {
        val itemCurrent = mainItems[position]
        holder.bind(itemCurrent)
    }

    override fun getItemCount(): Int {
        return mainItems.size
    }

    class ListProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ListItem) {
            val imgbuttonList: ImageView = itemView.findViewById(R.id.imageItemBotton)
            imgbuttonList.setImageResource(item.drawableId)
            val stringbuttonList: TextView = itemView.findViewById(R.id.textViewBotton)
            stringbuttonList.setText(item.textStringId)
        }
    }

}