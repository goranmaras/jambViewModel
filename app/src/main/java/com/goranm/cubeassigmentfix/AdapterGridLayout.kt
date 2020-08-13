package com.goranm.cubeassigmentfix

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.goranm.factoryzadatak3.model.DataWrapper
import com.goranm.factoryzadatak3.modelGridLayout.*
import kotlinx.android.synthetic.main.single_item_image.view.*
import kotlinx.android.synthetic.main.single_item_input.view.*
import kotlinx.android.synthetic.main.single_item_results.view.*
import kotlin.math.log

class AdapterGridLayout(private val list: MutableMap<Int,List<DataWrapper>>,
                        val fm: FragmentManager?,
                        var listClicked : ArrayList<Int>,
                        val bottomSheet: BottomSheetDialog
): RecyclerView.Adapter<AdapterGridLayout.BaseViewHolder<Any>>(), ShouldWriteDown {

    val TAG = "Grid"
    var map = HashMap<String,Int>()
    var canWriteDown = false
    var positionPassed : Int = 0
    var returnedPosition = 0

    inner class ImageViewHolder(itemView: View): BaseViewHolder<Image>(itemView){
        override fun bind(item: Image) {
            item.image?.let { itemView.ivInGrid.setImageResource(it) }

            itemView.ivInGrid.setOnClickListener {
                Log.d(TAG, "bind: ${canWriteDown}")
                Log.d(TAG, "bind: ${map.toString()}")
            }

        }
    }

    inner class InputViewHolder(itemView: View): BaseViewHolder<Input>(itemView){
        override fun bind(item: Input) {



            itemView.tvInputGrid.setOnClickListener {
                positionPassed = adapterPosition
                Log.d(TAG, "bind: $listClicked")
              //  bottomSheet.updateCubeList(sortHashMap(listofNums),positionPassed)
//                if (fm != null) {
//                    bottomSheet.show(fm,"BottomSheetDialog")
//                }
               // map.putAll(whichRowColoneIsClicked(adapterPosition,listofNums.sum()))
            }

//            if (canWriteDown && adapterPosition == returnedPosition){
//                if (itemView.tvInputGrid.text.isNullOrEmpty()){
//                    itemView.tvInputGrid.text = sortHashMap(listofNums).toString()
//                }
//            }



        }

    }

    inner class ResultViewHolder(itemView: View): BaseViewHolder<Result>(itemView){
        override fun bind(item: Result) {

            if (itemView.tvResultInGrid!=null)
            itemView.tvResultInGrid.setOnClickListener {
                when(adapterPosition){
                    43 -> {itemView.tvResultInGrid.text = map.values.sum().toString()
                    }
                }
            }



        }
    }

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return when(viewType) {
            R.layout.single_item_image-> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.single_item_image, parent, false)
                ImageViewHolder(view) as BaseViewHolder<Any>
            }
            R.layout.single_item_input-> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.single_item_input, parent, false)
                InputViewHolder(view) as BaseViewHolder<Any>
            }
            R.layout.single_item_results-> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.single_item_results, parent, false)
                ResultViewHolder(view) as BaseViewHolder<Any>
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {

       val valueList = list.values
        val flattendList = valueList.flatten()


        return flattendList[position].layoutID
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {

        val valueList = list.values
        val keyList = list.keys



        val flattendList = valueList.flatten()

        holder.bind(flattendList[position].data)


    }


    fun sortTheList(list: MutableMap<Int,List<DataWrapper>>, position: Int){



    }



    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    fun setList(list: ArrayList<Int>){
        this.listClicked = list
    }

    override fun getItemCount(): Int = list.size

    fun whichRowColoneIsClicked(n: Int, m: Int): HashMap<String,Int>{
        val mapWhich = HashMap<String,Int>()
        when(n%6){
            1 ->{
                mapWhich.put("ColoneOne"+n.toString(),m)
            }
            2 ->{}
            3 ->{}
            4 ->{}
            else -> {}
        }
        return mapWhich
    }

    fun clickedAdapterPosition(n: Int): Int{
        var m : Int = n
        return m
    }
//
//    override fun yesOrNo(checkifYesOrNo: Boolean, int: Int) {
//        canWriteDown = checkifYesOrNo
//        returnedPosition = int
//        notifyDataSetChanged()
//    }

    fun sortHashMap(hashMap: HashMap<String,Int>): ArrayList<Int>{

        val listSortedForSheet = arrayListOf<Int>()

        for (key in hashMap.keys){
            when(key){
                "valueOne" -> {
                    if (!hashMap["valueOne"]?.equals(0)!!)
                    listSortedForSheet.add(hashMap["valueOne"]!!)
                }
                "valueTwo" -> {
                    if (!hashMap["valueTwo"]?.equals(0)!!)
                        listSortedForSheet.add(hashMap["valueTwo"]!!)
                }
                "valueThree" -> {
                    if (!hashMap["valueThree"]?.equals(0)!!)
                        listSortedForSheet.add(hashMap["valueThree"]!!)
                }
                "valueFour" -> {
                    if (!hashMap["valueFour"]?.equals(0)!!)
                        listSortedForSheet.add(hashMap["valueFour"]!!)
                }
                "valueFive" -> {
                    if (!hashMap["valueFive"]?.equals(0)!!)
                        listSortedForSheet.add(hashMap["valueFive"]!!)
                }
                "valueSix" -> {
                    if (!hashMap["valueSix"]?.equals(0)!!)
                        listSortedForSheet.add(hashMap["valueSix"]!!)
                }
            }
        }

        return listSortedForSheet

    }

    override fun yesOrNo(checkifYesOrNo: Boolean, int: Int) {
        TODO("Not yet implemented")
    }


//    private fun sortListofNums(list: List<Int>): Int{
//        for (i in 1..6){
//            if (list.contains(i)){
//
//            }
//        }
//    }

}