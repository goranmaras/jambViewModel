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
        Cube(false, 1, R.drawable.dice1),
        Cube(false, 1, R.drawable.dice1),
        Cube(false, 1, R.drawable.dice1),
        Cube(false, 1, R.drawable.dice1),
        Cube(false, 1, R.drawable.dice1),
        Cube(false, 1, R.drawable.dice1)
    )

    private val _cubes = MutableLiveData<List<Cube>>(
        cubesList
    )
    val cubes : LiveData<List<Cube>>
    get() = _cubes


    val picturesList = mutableMapOf<Int,Int>(
        1 to R.drawable.dice1,
        2 to R.drawable.dice2,
        3 to R.drawable.dice3,
        4 to R.drawable.dice4,
        5 to R.drawable.dice5,
        6 to R.drawable.dice6
    )

    private val _pictures = MutableLiveData<Map<Int,Int>>(
        picturesList
    )
    val pictures : LiveData<Map<Int,Int>>
    get() = _pictures


     var canRollFirstTime = true
     var canRollSecondTime = false
     var canRollThirdTime = false

    val boolenList = mutableListOf<Boolean>(true,false,false,false)
    private val _bools = MutableLiveData<List<Boolean>>( boolenList )
    val bools : LiveData<List<Boolean>>
    get() = _bools


    fun onRollBtnClicked(){
        if (boolenList[0]){
            for (cube in cubesList){
                cube.rollRandomNumber()
                cube.pictureOfCube = picturesList[cube.diceNumber]!!
            }
            _cubes.value = cubesList

            boolenList[0] = false
            boolenList[1] = true
            _bools.value = boolenList
        }else if (boolenList[1]){
            for (cube in cubesList){
                cube.secondRollCheck()
                cube.pictureOfCube = picturesList[cube.diceNumber]!!
            }
            _cubes.value = cubesList
            boolenList[1] = false
            boolenList[2] = true
            _bools.value = boolenList
        }else if (boolenList[2]){
            for (cube in cubesList){
                cube.secondRollCheck()
                cube.pictureOfCube = picturesList[cube.diceNumber]!!
            }
            _cubes.value = cubesList
            boolenList[2]= false
            boolenList[3]= true
            _bools.value = boolenList
        }else if (boolenList[3]){
            _bools.value = boolenList
            resetingValues()
        }

    }

    private fun resetingValues(){

        for (cube in cubesList){
            cube.diceNumber = 1
            cube.isDiceEnabled = false
            cube.pictureOfCube = R.drawable.dice1
        }


        boolenList[0] = true
        boolenList[1] = false
        boolenList[2] = false
        boolenList[3] = false
        _bools.value = boolenList
    }


}