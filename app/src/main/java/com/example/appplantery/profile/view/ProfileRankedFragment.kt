package com.example.appplantery.profile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appplantery.R

class ProfileRankedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ranked, container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rankedItems = mutableListOf<ItemRankedButton>()
        rankedItems.add(
            ItemRankedButton(
                id = 1,
                drawableId = R.drawable.trofeuwhite96,
                textStringId = R.string.rank
            )
        )
        rankedItems.add(
            ItemRankedButton(
                id = 2,
                drawableId = R.drawable.usuariowhite96,
                textStringId = R.string.friends
            )
        )

        val rvRanked = view.findViewById<RecyclerView>(R.id.profile_rankd_rv)
        rvRanked.layoutManager = GridLayoutManager(context, 2)
        rvRanked.adapter = ProfileRankedAdapter(rankedItems)

    }

    private inner class ProfileRankedAdapter(private val rankedItems: List<ItemRankedButton>) : RecyclerView.Adapter<RankedViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankedViewHolder {
            return RankedViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.button_profile_ranked_rv, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return rankedItems.size
        }

        override fun onBindViewHolder(holder: RankedViewHolder, position: Int) {
            val itemCurrent = rankedItems[position]
            holder.bind(itemCurrent)
        }

    }


    private class RankedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: ItemRankedButton){
            val imgbuttonList: ImageView = itemView.findViewById(R.id.img_button_ranked)
            imgbuttonList.setImageResource(item.drawableId)
            val stringbuttonList: TextView = itemView.findViewById(R.id.txt_butom_rankd)
            stringbuttonList.setText(item.textStringId)

        }
    }

}
