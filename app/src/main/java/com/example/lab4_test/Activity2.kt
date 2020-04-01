package com.example.lab4_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class Activity2 : AppCompatActivity(), MenuTabs.OnFragmentInteractionListener {

    //FragmentManager используется для управления фрагментами
    private var manager: FragmentManager? = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        manager?.beginTransaction()?.add(R.id.frame1, MenuTabs(), "flag1")?.commit()
    }

    //выбор фрагментов из меню
    override fun onFragmentInteraction(result: String?) {
        manager?.beginTransaction()?.add(R.id.frame2, DetailsFragmentTask2.newInstance(result), "flag2")?.commit()
    }
}
