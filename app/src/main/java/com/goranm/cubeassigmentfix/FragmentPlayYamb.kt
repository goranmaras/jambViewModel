package com.goranm.cubeassigmentfix

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.goranm.cubeassigmentfix.ViewModel.PlayYambListener
import com.goranm.cubeassigmentfix.ViewModel.PlayYambViewModel
import com.goranm.factoryzadatak3.model.Cube
import kotlinx.android.synthetic.main.fragment_play_yamb.*

class FragmentPlayYamb : Fragment(R.layout.fragment_play_yamb), View.OnClickListener{


    val TAG = "FirstFragment"
    private var listClicked = arrayListOf<Int>()

    private val viewModel : PlayYambViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        val listOfImages = listOf<ImageView>(ivDice,ivDice2,ivDice3,ivDice4,ivDice5,ivDice6)

        btnRoll.setOnClickListener {
            viewModel.onRollBtnClicked(listOfImages, btnRoll)
        }



        btnPassData.setOnClickListener {
            Log.d(TAG, "onViewCreated: $listClicked")
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
            R.id.ivDice -> {
                viewModel.cubes.observe(viewLifecycleOwner, Observer { 
                    it[0].isDiceEnabled = true
                    listClicked.add(it[0].diceNumber)
                })
            }
            R.id.ivDice2 -> {viewModel.cubes.observe(viewLifecycleOwner, Observer {
                it[1].isDiceEnabled = true
                listClicked.add(it[1].diceNumber)
            })}
            R.id.ivDice3 -> {viewModel.cubes.observe(viewLifecycleOwner, Observer {
                it[2].isDiceEnabled = true
                listClicked.add(it[2].diceNumber)
            })}
            R.id.ivDice4 -> {viewModel.cubes.observe(viewLifecycleOwner, Observer {
                it[3].isDiceEnabled = true
                listClicked.add(it[3].diceNumber)
            })}
            R.id.ivDice5 -> {viewModel.cubes.observe(viewLifecycleOwner, Observer {
                it[4].isDiceEnabled = true
                listClicked.add(it[4].diceNumber)
            })}
            R.id.ivDice6 -> {viewModel.cubes.observe(viewLifecycleOwner, Observer {
                it[5].isDiceEnabled = true
                listClicked.add(it[5].diceNumber)
            })}
            else->{
                return
            }
        }
    }





}