package com.goranm.cubeassigmentfix

import androidx.fragment.app.Fragment

interface FromPlayYambToPaper {
    fun updateCubeList(list: ArrayList<Int>)
    fun updateRolledList(list: ArrayList<Int>)
}
interface ShouldWriteDown{
    fun yesOrNo(checkifYesOrNo: Boolean, int: Int)
}

interface WhichFragment{
    fun ivGotTheFraower(fragment: Fragment)
}