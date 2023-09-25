package com.example.myapplication.ui.skill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSkillBinding


class ProgrammingLanguageAdapter(val list : ArrayList<ProgrammingLanguage>) : RecyclerView.Adapter<ProgrammingLanguageAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentSkillBinding) : RecyclerView.ViewHolder(itemBinding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentSkillBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.imgView.setImageResource(list[position].image)
        holder.itemBinding.txtTitle.text = list[position].name
    }


}
