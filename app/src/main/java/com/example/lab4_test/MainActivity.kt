package com.example.lab4_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when ((view as Button).id) {
            //Создание макета из 4 частей, вывод зависит от ориентации экрана
            R.id.task1 -> startActivity(Intent(this, Activity1::class.java))
            //Два фрагмента, при нажатии открывается информация при переходе на ссылку
            R.id.task2 -> startActivity(Intent(this, Activity2::class.java))
            //Приложения со слайдером для картинок
            R.id.task3 -> startActivity(Intent(this, Activity3::class.java))
        }
    }
}
