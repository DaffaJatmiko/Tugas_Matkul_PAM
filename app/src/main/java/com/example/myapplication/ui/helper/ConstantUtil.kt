package com.example.myapplication.ui.helper

import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ui.skill.ProgrammingLanguage


object ConstantUtil {
    fun getSkillData(fragment: Fragment):ArrayList<ProgrammingLanguage> {
        val skillArrayList = ArrayList<ProgrammingLanguage>()
        val skills = fragment.resources.getStringArray(R.array.string_skills_array)
        val images = fragment.resources.obtainTypedArray(R.array.integer_skills_image)
        for (i in 0 until  skills.size) {
            skillArrayList.add(ProgrammingLanguage(images.getResourceId(i,0), skills[i]))
        }
        images.recycle()
        return skillArrayList
    }
}