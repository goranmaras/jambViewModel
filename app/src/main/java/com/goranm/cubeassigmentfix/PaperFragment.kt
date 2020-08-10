package com.goranm.cubeassigmentfix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.goranm.factoryzadatak3.model.DataWrapper
import com.goranm.factoryzadatak3.modelGridLayout.Image
import com.goranm.factoryzadatak3.modelGridLayout.Input
import com.goranm.factoryzadatak3.modelGridLayout.Result
import kotlinx.android.synthetic.main.fragment_paper.*


class PaperFragment : Fragment(R.layout.fragment_paper) {

    val TAG = "PaperFragment"

    private var listRolled = arrayListOf<Int>()
    private var listClicked = arrayListOf<Int>()

    val bottomSheet = BottomSheetDialog()

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewManager = GridLayoutManager(context,6, GridLayoutManager.VERTICAL,false)
        viewAdapter = AdapterGridLayout(generateListGrid(),fragmentManager,listClicked, bottomSheet)
        recyclerView = rvPaper.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }



        bottomSheet.listener = rvPaper.adapter as ShouldWriteDown
    }

    private fun generateListGrid(): List<DataWrapper>{
        val list = listOf<DataWrapper>(
            DataWrapper(R.layout.single_item_image, Image()),
            DataWrapper(R.layout.single_item_image, Image(R.drawable.arrowdown)),
            DataWrapper(R.layout.single_item_image, Image(R.drawable.arrowup)),
            DataWrapper(R.layout.single_item_image, Image(R.drawable.arrowboth)),
            DataWrapper(R.layout.single_item_image, Image(R.drawable.najava)),
            DataWrapper(R.layout.single_item_image, Image()),

            DataWrapper(R.layout.single_item_image, Image(R.drawable.dice1)),
            DataWrapper(R.layout.single_item_input, Input(true)),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_image, Image()),
            //-------druga
            DataWrapper(R.layout.single_item_image, Image(R.drawable.dice2)),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_image, Image()),

            DataWrapper(R.layout.single_item_image, Image(R.drawable.dice3)),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_image, Image()),

            DataWrapper(R.layout.single_item_image, Image(R.drawable.dice4)),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_image, Image()),

            DataWrapper(R.layout.single_item_image, Image(R.drawable.dice5)),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_image, Image()),

            DataWrapper(R.layout.single_item_image, Image(R.drawable.dice6)),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_input, Input()),
            DataWrapper(R.layout.single_item_image, Image()),

            DataWrapper(R.layout.single_item_image, Image(R.drawable.zbroj)),
            DataWrapper(R.layout.single_item_results, Result()),
            DataWrapper(R.layout.single_item_results, Result()),
            DataWrapper(R.layout.single_item_results, Result()),
            DataWrapper(R.layout.single_item_results, Result()),
            DataWrapper(R.layout.single_item_results, Result())
        )

        return list
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }




}