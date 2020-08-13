package com.goranm.cubeassigmentfix.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goranm.cubeassigmentfix.R
import com.goranm.factoryzadatak3.model.Cube
import com.goranm.factoryzadatak3.model.DataWrapper
import com.goranm.factoryzadatak3.modelGridLayout.Image
import com.goranm.factoryzadatak3.modelGridLayout.Input
import com.goranm.factoryzadatak3.modelGridLayout.Result

class PaperFragmentViewModel : ViewModel(){



    val firstColone = mutableListOf<DataWrapper>(
        DataWrapper(R.layout.single_item_image, Image()),
        DataWrapper(R.layout.single_item_image, Image(R.drawable.dice1)),
        DataWrapper(R.layout.single_item_image, Image(R.drawable.dice2)),
        DataWrapper(R.layout.single_item_image, Image(R.drawable.dice3)),
        DataWrapper(R.layout.single_item_image, Image(R.drawable.dice4)),
        DataWrapper(R.layout.single_item_image, Image(R.drawable.dice5)),
        DataWrapper(R.layout.single_item_image, Image(R.drawable.dice6)),
        DataWrapper(R.layout.single_item_image, Image(R.drawable.zbroj))
    )
    val secondColone = mutableListOf<DataWrapper>(
        DataWrapper(R.layout.single_item_image, Image(R.drawable.arrowdown)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Result())
    )
    val thirdColone = mutableListOf<DataWrapper>(
        DataWrapper(R.layout.single_item_image, Image(R.drawable.arrowup)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Result())
    )
    val fourthColone = mutableListOf<DataWrapper>(
        DataWrapper(R.layout.single_item_image, Image(R.drawable.arrowboth)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Result())
    )
    val fifthColone = mutableListOf<DataWrapper>(
        DataWrapper(R.layout.single_item_image, Image(R.drawable.najava)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Input(true)),
        DataWrapper(R.layout.single_item_input, Result())
    )
    val sixthColone = mutableListOf<DataWrapper>(
        DataWrapper(R.layout.single_item_image, Image()),
        DataWrapper(R.layout.single_item_input, Image()),
        DataWrapper(R.layout.single_item_input, Image()),
        DataWrapper(R.layout.single_item_input, Image()),
        DataWrapper(R.layout.single_item_input, Image()),
        DataWrapper(R.layout.single_item_input, Image()),
        DataWrapper(R.layout.single_item_input, Image()),
        DataWrapper(R.layout.single_item_input, Result())
    )

    val coloneRowDataMap = mutableMapOf<Int,List<DataWrapper>>(
        1 to firstColone,
        2 to secondColone,
        3 to thirdColone,
        4 to fourthColone,
        5 to fifthColone,
        6 to sixthColone
    )


    private val _generatedList = MutableLiveData<MutableMap<Int,List<DataWrapper>>>(
        coloneRowDataMap
    )
    val geenratedList : LiveData<MutableMap<Int,List<DataWrapper>>>
        get() = _generatedList



}