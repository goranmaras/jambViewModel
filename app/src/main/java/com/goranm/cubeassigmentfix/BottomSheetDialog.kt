package com.goranm.cubeassigmentfix

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_layout.*
import kotlinx.android.synthetic.main.single_item_input.*
import java.lang.ClassCastException

class BottomSheetDialog: BottomSheetDialogFragment(), ShouldWriteDown {

    val TAG = "BottomSheetDialog"

    var listener : ShouldWriteDown? = null

    private var listRolled = arrayListOf<Int>()


    var positionFromadapter = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v =inflater.inflate(R.layout.bottom_sheet_layout, container, false)

       val btnSheetDialogYes = v.findViewById<Button>(R.id.btnSheetDialogYes)
       val btnSheetDialogNo = v.findViewById<Button>(R.id.btnSheetDialogNo)
       val textfromfragment = v.findViewById<TextView>(R.id.tvSheetDialogQuestion)



        textfromfragment.text = "Would you like to write down number: ${listRolled}"

        btnSheetDialogYes.setOnClickListener {
            listener?.yesOrNo(true, positionFromadapter)
            dismiss()
            Log.d(TAG, "onCreateView: $listRolled")
        }

        btnSheetDialogNo.setOnClickListener {
            listener?.yesOrNo(false, positionFromadapter)
            dismiss()
        }

        return v
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)

    }

    override fun yesOrNo(checkifYesOrNo: Boolean, int: Int) {
        TODO("Not yet implemented")
    }

}