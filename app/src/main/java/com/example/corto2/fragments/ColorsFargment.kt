package com.example.corto2.fragments

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.corto2.R
import com.example.corto2.consts.consts
import kotlinx.android.synthetic.main.fragment_buttons.view.*
import kotlinx.android.synthetic.main.fragment_colors.*
import kotlinx.android.synthetic.main.fragment_colors.view.*



class ColorsFargment : Fragment() {

    private var listenerTool: ButtonsFragment.ButtonsListenerTools? = null


    var colors : Int = 0


    companion object {

            @JvmStatic
            fun newInstance(int: Int): ColorsFargment {
                val instance = ColorsFargment()
                instance.colors = int
                return instance
            }

        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)


        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            // Inflate the layout for this fragment
            val view = inflater.inflate(R.layout.fragment_colors, container, false)
            view.btn_color.setBackgroundColor(colors)

            setNavigationListeners(view)
            return view
        }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ButtonsFragment.ButtonsListenerTools) {
            listenerTool = context
        } else {
            throw RuntimeException(context.toString() + " must implement ButtonListenerTools") as Throwable
        }

    }

        override fun onDetach() {
            super.onDetach()
            listenerTool = null

        }

    interface ButtonsListenerTools{
        fun onClick2(nav_direction_degradado: String)
    }

    private fun setNavigationListeners(view: View){
        view.btn_change1.setOnClickListener{
            listenerTool?.onClick(consts.left_ID)
        }
        view.btn_change2.setOnClickListener{
            listenerTool?.onClick(consts.right_ID)
        }
    }



}
