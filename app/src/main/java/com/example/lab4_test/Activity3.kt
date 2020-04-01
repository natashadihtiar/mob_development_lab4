package com.example.lab4_test

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Activity3 : AppCompatActivity() {

    //Вызов объкта FragmentManager
    private var manager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        //получение ссылок
        val pager: ViewPager = findViewById(R.id.pager)
        val tabLayout: TabLayout = findViewById(R.id.tabs)

        pager.adapter = MyAdapter(manager) //виджет табов
        pager.setPageTransformer(false, ZoomOutPageTransformer()) //слайд табов

        tabLayout.setupWithViewPager(pager)
    }

    //Управление фрагментами
    @Suppress("DEPRECATION")
    class MyAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        //Название таба
        @Nullable
        override fun getPageTitle(position: Int): CharSequence = "Tab" + (position+1).toString()
        //Получение объекта
        override fun getItem(i: Int): Fragment = DetailsFragmentTask3.newInstance("image" + (i+1).toString())
        //Всего 3 картинки
        override fun getCount(): Int = 3
    }
}
