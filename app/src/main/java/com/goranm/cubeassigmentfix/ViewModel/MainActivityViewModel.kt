package com.goranm.cubeassigmentfix.ViewModel

import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goranm.cubeassigmentfix.FragmentPlayYamb
import com.goranm.cubeassigmentfix.PaperFragment
import com.goranm.cubeassigmentfix.R
import com.goranm.factoryzadatak3.model.Cube

class MainActivityViewModel : ViewModel() {

    val frags = listOf<Fragment>(
        FragmentPlayYamb(), PaperFragment()
    )

    private val _fragments = MutableLiveData<List<Fragment>>(
        frags
    )

    val fragment : LiveData<List<Fragment>>
        get() = _fragments




}