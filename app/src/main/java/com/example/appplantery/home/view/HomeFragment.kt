package com.example.appplantery.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appplantery.R
import com.example.appplantery.databinding.FragmentHomeBinding
import com.example.appplantery.profile.view.ListItem

class HomeFragment : Fragment() {
    private  lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.beige_light)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val cardItems = mutableListOf<CardListItem>()
        cardItems.add(
            CardListItem(
                id = 1,
                textHeadStringId = R.string.title1,
                drawableId = R.drawable.vaso_1,
                textDescStringId = R.string.account
            )
        )
        cardItems.add(
            CardListItem(
                id = 2,
                textHeadStringId = R.string.title2,
                drawableId = R.drawable.vaso_2,
                textDescStringId = R.string.account
            )
        )
        cardItems.add(
            CardListItem(
                id = 3,
                textHeadStringId = R.string.title3,
                drawableId = R.drawable.vaso_1,
                textDescStringId = R.string.account
            )
        )
        cardItems.add(
            CardListItem(
                id = 4,
                textHeadStringId = R.string.title4,
                drawableId = R.drawable.vaso_2,
                textDescStringId = R.string.account
            )
        )
        cardItems.add(
            CardListItem(
                id = 5,
                textHeadStringId = R.string.title5,
                drawableId = R.drawable.vaso_1,
                textDescStringId = R.string.account
            )
        )

        val rvCardView = view.findViewById<RecyclerView>(R.id.home_card_rv)
        rvCardView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL , false)
        rvCardView.adapter = ListAdapter(cardItems)
    }

    private inner class ListAdapter(private val cardItems: List<CardListItem>) : RecyclerView.Adapter<ListAdapter.ListHomeViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHomeViewHolder {
            return ListHomeViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_card_home, parent, false)
            )
        }

        override fun onBindViewHolder(holder: ListHomeViewHolder, position: Int) {
            val itemCurrent = cardItems[position]
            holder.bind(itemCurrent)
        }

        override fun getItemCount(): Int {
            return cardItems.size
        }

        private inner class ListHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

}