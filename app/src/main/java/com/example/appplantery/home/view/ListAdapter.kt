package com.example.appplantery.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appplantery.R
import com.example.appplantery.profile.view.ListItem

class ListAdapter(private val mainItems: List<CardListItem>) : RecyclerView.Adapter<ListAdapter.ListHomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHomeViewHolder {
        return ListHomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_card_home, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListHomeViewHolder, position: Int) {
        val itemCurrent = mainItems[position]
        holder.bind(itemCurrent)
    }

    override fun getItemCount(): Int {
        return mainItems.size
    }

    class ListHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CardListItem) {
            val stringTitleList: TextView = itemView.findViewById(R.id.textTitleCardView)
            stringTitleList.setText(item.textHeadStringId)
            val imgCardList: ImageView = itemView.findViewById(R.id.imageCardView)
            imgCardList.setImageResource(item.drawableId)
            val stringDescList: TextView = itemView.findViewById(R.id.textDescView)
            stringDescList.setText(item.textDescStringId)
        }
    }

}