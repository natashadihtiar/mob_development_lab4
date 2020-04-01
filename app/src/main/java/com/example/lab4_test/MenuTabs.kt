package com.example.lab4_test

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

class MenuTabs : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null

    //Метод, который вызывается при вызовеActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is OnFragmentInteractionListener) {
            context
        } else {
            throw RuntimeException(
                "$context must implement OnFragmentInteractionListener"
            )
        }
    }

    //Вызывается при отключении Activity
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(result: String?)
    }
    //При создании макета
    override fun onCreateView(@NonNull inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        // Взаимодействие layout  и фрагмента
        return inflater.inflate(R.layout.tab_menu, container, false)
    }

    //После создания макета
    override fun onViewCreated(@NonNull view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Отслеживатель события нажатия кнопки и переход по указанной ссылке
        view.findViewById<Button>(R.id.buttonGoogle).setOnClickListener {
            mListener?.onFragmentInteraction("http://www.google.com/")
        }
        view.findViewById<Button>(R.id.buttonFacebook).setOnClickListener {
            mListener?.onFragmentInteraction("http://www.facebook.com/")
        }
        view.findViewById<Button>(R.id.buttonTwitter).setOnClickListener {
            mListener?.onFragmentInteraction("http://www.twitter.com/")
        }
        view.findViewById<Button>(R.id.buttonXda).setOnClickListener {
            mListener?.onFragmentInteraction("http://www.xda-developers.com/")
        }
    }
}
