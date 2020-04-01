package com.example.lab4_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment

// Инициализация параметров
private const val ARG_PARAM1 = "param1"

class DetailsFragmentTask2() : Fragment() {

    private var mParam1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mParam1 = it.getString(ARG_PARAM1)
        }
    }

    //Метод вызова, чтобы фрагмент открыл свой макет
    override fun onCreateView(@NonNull inflater: LayoutInflater, @NonNull container: ViewGroup?, @NonNull savedInstanceState: Bundle?): View? {
        // Взаимосвязь loyout с фрагментами
        return inflater.inflate(R.layout.tab_2, container, false)
    }

    //Значения полей фрагментов
    override fun onViewCreated(@NonNull view: View, @NonNull savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//Переход по указанным ссылкам
        val webView: WebView = view.findViewById(R.id.webView)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl(mParam1)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String?): DetailsFragmentTask2 {
            val fragment = DetailsFragmentTask2()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
