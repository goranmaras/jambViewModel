package com.goranm.cubeassigmentfix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.goranm.cubeassigmentfix.ViewModel.PaperFragmentViewModel
import com.goranm.cubeassigmentfix.ViewModel.PlayYambViewModel
import com.goranm.cubeassigmentfix.utils.AutoFillGridLayoutManager
import com.goranm.cubeassigmentfix.utils.ScreenValues
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

    lateinit var viewModel: PaperFragmentViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(PaperFragmentViewModel::class.java)


       viewManager = GridLayoutManager(context,6, GridLayoutManager.VERTICAL,false)
      //  viewManager = AutoFillGridLayoutManager(requireContext().applicationContext, ScreenValues.DEVICE_WIDTH.size / ScreenValues.COLUMN_NUMBER.size)
        viewAdapter = AdapterGridLayout(viewModel.coloneRowDataMap,fragmentManager,listClicked, bottomSheet)


        recyclerView = rvPaper.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }



        bottomSheet.listener = rvPaper.adapter as ShouldWriteDown
    }




}