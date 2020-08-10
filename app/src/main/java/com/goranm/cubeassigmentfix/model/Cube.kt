package com.goranm.factoryzadatak3.model

data class Cube (
    var isDiceEnabled: Boolean,
    var diceNumber: Int,
    var cubeNCounter: Int? = 0
) {

    fun rollRandomNumber(): Int {
        this.diceNumber = (1..6).random()
        return diceNumber
    }

    fun secondRollCheck(): Int {
        if (!isDiceEnabled){
            return rollRandomNumber()
        } else return this.diceNumber
    }

}