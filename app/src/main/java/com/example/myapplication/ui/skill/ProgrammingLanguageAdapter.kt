package com.example.myapplication.ui.skill

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemBinding


class ProgrammingLanguageAdapter(private val list : ArrayList<ProgrammingLanguage>, private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<ProgrammingLanguageAdapter.MyView>() {

    inner class MyView(val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemView.setOnClickListener {
                onItemClick(list[bindingAdapterPosition].name)
            }
        }
    }

    fun setData(newList: List<ProgrammingLanguage>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemBinding.inflate(inflater, parent, false)

        return MyView(itemBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val currentItem = list[position]


        with(holder.itemBinding) {
            imgView.setImageResource(currentItem.image)
            txtTitle.text = currentItem.name


            root.setOnClickListener {
                onItemClick(currentItem.name)
            }
        }
    }


}
