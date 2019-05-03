package com.example.corto2.activities

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.corto2.R
import com.example.corto2.consts.consts
import com.example.corto2.fragments.ButtonsFragment
import com.example.corto2.fragments.ColorsFargment

class MainActivity : AppCompatActivity(), ButtonsFragment.ButtonsListenerTools, ColorsFargment.ButtonsListenerTools {



    val color_rojo = ColorsFargment.newInstance(Color.RED)
    val color_verde = ColorsFargment.newInstance(Color.GREEN)
    val color_azul = ColorsFargment.newInstance(Color.BLUE)
    val fragment_list = listOf<ColorsFargment>(color_rojo, color_verde, color_azul)
    var curr: Int = 0

    val color_rojo_degradado = ColorsFargment.newInstance(Color.rgb(114,6,6))
    val color_verde_degradado = ColorsFargment.newInstance(Color.rgb(0,140,0))
    val color_azul_degradado = ColorsFargment.newInstance(Color.rgb(0,0,140))
    val fragment_list_degradado = listOf<ColorsFargment>(color_rojo_degradado, color_verde_degradado, color_azul_degradado)
    var curr2: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInitialFragment()
    }

    private fun changeFragment(newFragment: ColorsFargment){
        supportFragmentManager.beginTransaction().replace(R.id.activity_main_FrameLayout_imageFragmentHolder, newFragment).commit()
    }

    private fun setInitialFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.activity_main_FrameLayout_imageFragmentHolder, color_rojo).commit()
    }


    //ACA PASO EL COLOR POR LOS BOTONES DE ARRIBA

    override fun onClick(nav_direction: String) {
        if(nav_direction == consts.left_ID){
            if(curr == 0){
                curr = 2
                changeFragment(fragment_list[curr])
            }
            else{
                curr -=1
                changeFragment(fragment_list[curr])
            }
        }
        if(nav_direction == consts.right_ID){
            if(curr == 2){
                curr = 0
                changeFragment(fragment_list[curr])
            }
            else{
                curr +=1
                changeFragment(fragment_list[curr])
            }
        }
    }

    //ACA PASO EL COLOR POR LOS BOTONES DE LOS LADOS

    override fun onClick2(nav_direction_degradado: String) {
        if(nav_direction_degradado == consts.left_ID){
            if(curr2 == 0){
                curr2 = 2
                changeFragment(fragment_list_degradado[curr2])
            }
            else{
                curr2 -=1
                changeFragment(fragment_list_degradado[curr2])
            }
        }
        if(nav_direction_degradado == consts.right_ID){
            if(curr2 == 2){
                curr2 = 0
                changeFragment(fragment_list_degradado[curr2])
            }
            else{
                curr2 +=1
                changeFragment(fragment_list_degradado[curr2])
            }
        }
    }

}


