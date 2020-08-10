package com.goranm.factoryzadatak3.modelGridLayout

data class Input(
    var isTyped: Boolean? = false,
    var input: String? = null,
    var listOfInput: MutableList<Int> = ArrayList()
) {
}