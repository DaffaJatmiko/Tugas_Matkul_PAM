package com.example.myapplication.ui.skill

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSkillBinding
import java.util.Locale


class SkillFragment : Fragment() {


    //    private lateinit var list: ArrayList<ProgrammingLanguage>
    private var _binding: FragmentSkillBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var originalList: ArrayList<ProgrammingLanguage>
    private lateinit var currentList: ArrayList<ProgrammingLanguage>
    private lateinit var adapter: ProgrammingLanguageAdapter
//    private var filteredList: List<ProgrammingLanguage> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSkillBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerViewSkill

        recyclerView.setHasFixedSize(true)

        originalList = ArrayList()
        originalList.add(ProgrammingLanguage(R.drawable.kotlin, "Kotlin"))
        originalList.add(ProgrammingLanguage(R.drawable.java, "Java"))
        originalList.add(ProgrammingLanguage(R.drawable.js, "JavaScript"))
        originalList.add(ProgrammingLanguage(R.drawable.python, "Python"))
        originalList.add(ProgrammingLanguage(R.drawable.golang, "Golang"))
        originalList.add(ProgrammingLanguage(R.drawable.kotlin, "Kotlin"))
        originalList.add(ProgrammingLanguage(R.drawable.java, "Java"))
        originalList.add(ProgrammingLanguage(R.drawable.js, "JavaScript"))
        originalList.add(ProgrammingLanguage(R.drawable.python, "Python"))
        originalList.add(ProgrammingLanguage(R.drawable.golang, "Golang"))

        currentList = ArrayList(originalList)
        adapter = ProgrammingLanguageAdapter(currentList){ clickedItem ->
            navigateToDetail(clickedItem)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("SkillFragment", "onQueryTextChange: $newText")
                filterData(newText)
                return true
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun filterData(query: String?) {
        Log.d("SkillFragment", "Query: $query")
        if (query != null) {
            val filteredList = originalList.filter { it.name.lowercase(Locale.ROOT).contains(query) }
            Log.d("SkillFragment", "FilteredList: $filteredList")

            if (filteredList.isEmpty()) {
                Toast.makeText(requireContext(), "Tidak ada data ditemukan", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setData(ArrayList(filteredList))
                adapter.notifyDataSetChanged()
            }
        }

    }
    private fun navigateToDetail(extraName: String){
        val bundle = Bundle()
        bundle.putString("extra_name", extraName)
        findNavController().navigate(R.id.action_nav_skill_to_skill_detail, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        setHasOptionsMenu(false)
        _binding = null
    }
}
