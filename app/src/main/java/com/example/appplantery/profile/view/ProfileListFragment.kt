package com.example.appplantery.profile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appplantery.R
import com.example.appplantery.databinding.FragmentProfileListBinding

class ProfileListFragment : Fragment (R.layout.fragment_profile_list) {
    private var binding: FragmentProfileListBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileListBinding.bind(view)

        val mainItems = mutableListOf<ListItem>()
        mainItems.add(
            ListItem(
                id = 1,
                drawableId = R.drawable.ic_insta_profile,
                textStringId = R.string.account,
                endBottonId = R.drawable.ic_next
            )
        )
        mainItems.add(
            ListItem(
                id = 2,
                drawableId = R.drawable.ic_notification,
                textStringId = R.string.notification,
                endBottonId = R.drawable.ic_next
            )
        )
        mainItems.add(
            ListItem(
                id = 3,
                drawableId = R.drawable.settings36,
                textStringId = R.string.settings,
                endBottonId = R.drawable.ic_next
            )
        )
        mainItems.add(
            ListItem(
                id = 4,
                drawableId = R.drawable.question32,
                textStringId = R.string.help,
                endBottonId = R.drawable.ic_next
            )
        )

        binding?.profileListRv?.layoutManager = LinearLayoutManager(context)
        binding?.profileListRv?.adapter = ListAdapter(mainItems)

    }

    private inner class ListAdapter(private val mainItems: List<ListItem>) : RecyclerView.Adapter<ListAdapter.ListProfileViewHolder>() {

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

        private inner class ListProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: ListItem) {
                val imgbuttonList: ImageView = itemView.findViewById(R.id.imageItemBotton)
                imgbuttonList.setImageResource(item.drawableId)
                val stringbuttonList: TextView = itemView.findViewById(R.id.textViewBotton)
                stringbuttonList.setText(item.textStringId)
            }
        }

    }

}