package com.example.lab4_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment

// Инициализация параметров фрагментов
private const val ARG_PARAM1 = "param1"

class DetailsFragmentTask3 : Fragment() {

    private var mParam1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mParam1 = it.getString(ARG_PARAM1)
        }
    }

    //Метод вызова, чтобы отображать макеты
    override fun onCreateView(@NonNull inflater: LayoutInflater, @NonNull container: ViewGroup?, @NonNull savedInstanceState: Bundle?): View? {
        // Взаимосвязь Layout с фрагментами
        return inflater.inflate(R.layout.tab_3, container, false)
    }

    //Значения полей
    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun onViewCreated(@NonNull view: View, @NonNull savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//Установка картинок
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val resID = resources.getIdentifier(mParam1, "drawable", context?.packageName)
        imageView.setImageResource(resID)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String?): DetailsFragmentTask3 {
            val fragment = DetailsFragmentTask3()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
