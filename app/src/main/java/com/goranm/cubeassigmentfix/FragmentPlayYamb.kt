package com.goranm.cubeassigmentfix

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.goranm.cubeassigmentfix.ViewModel.PaperFragmentViewModel
import com.goranm.cubeassigmentfix.ViewModel.PlayYambViewModel
import com.goranm.factoryzadatak3.model.Cube
import kotlinx.android.synthetic.main.fragment_play_yamb.*

class FragmentPlayYamb : Fragment(R.layout.fragment_play_yamb), View.OnClickListener{


    val TAG = "FirstFragment"
    private var listClicked = arrayListOf<Int>()


    lateinit var viewModel: PlayYambViewModel
    lateinit var viewmodelTest: PaperFragmentViewModel
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        val listOfImages = listOf<ImageView>(ivDice,ivDice2,ivDice3,ivDice4,ivDice5,ivDice6)
        val listOfBtnRollImages = listOf<Int>(R.drawable.button_first_r,R.drawable.button_second_r,R.drawable.button_third_r,R.drawable.button_start)

        viewModel = ViewModelProvider(requireActivity()).get(PlayYambViewModel::class.java)
        viewmodelTest = ViewModelProvider(requireActivity()).get(PaperFragmentViewModel::class.java)

        viewModel.cubes.observe(viewLifecycleOwner, Observer {
            displayImage(listOfImages,it)
        })


        viewModel.bools.observe(viewLifecycleOwner, Observer {
            btnRollPictureChange(listOfBtnRollImages,it,btnRoll)
        })

        btnRoll.setOnClickListener {
            viewModel.onRollBtnClicked()
        }


        btnPassData.setOnClickListener {
            val some = viewmodelTest.coloneRowDataMap
            val somene = some.values
            Log.d(TAG, "onViewCreated: ${somene.flatten()}")
        }

    }

    private fun initView(){
        val ivDiceOne = getView()?.findViewById<ImageView>(R.id.ivDice)
        ivDiceOne?.setOnClickListener { onClick(ivDiceOne) }
        val ivDiceTwo = getView()?.findViewById<ImageView>(R.id.ivDice2)
        ivDiceTwo?.setOnClickListener { onClick(ivDiceTwo) }
        val ivDiceThree = getView()?.findViewById<ImageView>(R.id.ivDice3)
        ivDiceThree?.setOnClickListener { onClick(ivDiceThree) }
        val ivDiceFour = getView()?.findViewById<ImageView>(R.id.ivDice4)
        ivDiceFour?.setOnClickListener { onClick(ivDiceFour) }
        val ivDiceFive = getView()?.findViewById<ImageView>(R.id.ivDice5)
        ivDiceFive?.setOnClickListener { onClick(ivDiceFive) }
        val ivDiceSix = getView()?.findViewById<ImageView>(R.id.ivDice6)
        ivDiceSix?.setOnClickListener { onClick(ivDiceSix) }


    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ivDice -> {viewModel.cubesList[0].isDiceEnabled = true }
            R.id.ivDice2 -> {viewModel.cubesList[1].isDiceEnabled = true}
            R.id.ivDice3 -> {viewModel.cubesList[2].isDiceEnabled = true}
            R.id.ivDice4 -> {viewModel.cubesList[3].isDiceEnabled = true}
            R.id.ivDice5 -> {viewModel.cubesList[4].isDiceEnabled = true}
            R.id.ivDice6 -> {viewModel.cubesList[5].isDiceEnabled = true}
            else->{
                return
            }
        }
    }


    fun displayImage(list: List<ImageView>, cubes : List<Cube>){
        for (i in cubes.indices){
            list[i].setImageResource(cubes[i].pictureOfCube)
        }

    }

    fun btnRollPictureChange(list: List<Int>,bools: List<Boolean>, button: ImageButton){

        if (bools[0]){
            button.setImageResource(list[0])
        }else if (bools[1]){
            button.setImageResource(list[1])
        }else if (bools[2]){
            button.setImageResource(list[2])
        }else if (bools[3]){
            button.setImageResource(list[3])
            button.isEnabled = false
        }




    }

}