package com.example.myapplication.ui.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSkillBinding

class SkillFragment : Fragment() {

    private lateinit var adapter: ProgrammingLanguageAdapter
    private lateinit var list: ArrayList<ProgrammingLanguage>
    private lateinit var binding: FragmentSkillBinding

    // Menambahkan deklarasi RecyclerView di luar onCreate
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSkillBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menginisialisasi recyclerView menggunakan findViewById
        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_skill)
        recyclerView.setHasFixedSize(true)

        list = ArrayList()
        list.add(ProgrammingLanguage(R.drawable.kotlin, "Kotlin"))
        list.add(ProgrammingLanguage(R.drawable.java, "Java"))
        list.add(ProgrammingLanguage(R.drawable.js, "JavaScript"))
        list.add(ProgrammingLanguage(R.drawable.python, "Python"))
        list.add(ProgrammingLanguage(R.drawable.golang, "Golang"))
        list.add(ProgrammingLanguage(R.drawable.kotlin, "Kotlin"))
        list.add(ProgrammingLanguage(R.drawable.java, "Java"))
        list.add(ProgrammingLanguage(R.drawable.js, "JavaScript"))
        list.add(ProgrammingLanguage(R.drawable.python, "Python"))
        list.add(ProgrammingLanguage(R.drawable.golang, "Golang"))



        adapter = ProgrammingLanguageAdapter(list)

        // Mengatur adapter ke recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
    }
}
