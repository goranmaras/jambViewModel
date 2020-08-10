package com.goranm.cubeassigmentfix.ViewModel

import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goranm.cubeassigmentfix.FragmentPlayYamb
import com.goranm.cubeassigmentfix.R
import com.goranm.factoryzadatak3.model.Cube
import kotlinx.android.synthetic.main.fragment_play_yamb.*

class PlayYambViewModel : ViewModel()  {

    private val TAG = "HEY"

    val cubesList = mutableListOf<Cube>(
        Cube(false, 1),
        Cube(false, 1),
        Cube(false, 1),
        Cube(false, 1),
        Cube(false, 1),
        Cube(false, 1)
    )

    private val _cubes = MutableLiveData<List<Cube>>(
        cubesList
    )
    val cubes : LiveData<List<Cube>>
    get() = _cubes



    private var canRollFirstTime = true
    private var canRollSecondTime = false
    private var canRollThirdTime = false



    fun onRollBtnClicked(imageView: List<ImageView>,btnPic: ImageButton){
        if (canRollFirstTime){
            for (i in imageView.indices){
                imageView[i].setImageLevel(cubesList[i].rollRandomNumber())
            }
            canRollFirstTime = false
            canRollSecondTime = true
            btnPic.setImageResource(R.drawable.button_first_r)
        }else if (canRollSecondTime){
            for (i in imageView.indices){
                imageView[i].setImageLevel(cubesList[i].secondRollCheck())
            }
            canRollSecondTime = false
            canRollThirdTime = true
            btnPic.setImageResource(R.drawable.button_second_r)
        }else if (canRollThirdTime){
            btnPic.setImageResource(R.drawable.button_third_r)
            for (i in imageView.indices){
                imageView[i].setImageLevel(cubesList[i].secondRollCheck())
            }
            resetingValues()
           btnPic.isEnabled = false
        }

    }

    private fun resetingValues(){

        for (cube in cubesList){
            cube.diceNumber = 1
            cube.isDiceEnabled = false
        }

        canRollFirstTime = true
        canRollSecondTime = false
        canRollThirdTime = false
    }


}