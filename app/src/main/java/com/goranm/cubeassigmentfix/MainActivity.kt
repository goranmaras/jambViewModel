package com.goranm.cubeassigmentfix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.goranm.cubeassigmentfix.ViewModel.MainActivityViewModel
import com.goranm.cubeassigmentfix.ViewModel.PlayYambViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_play_yamb.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"



    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        setCurrentFragment(viewModel.frags[0])

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.fragmentPlayYamb -> setCurrentFragment(viewModel.frags[0])
                R.id.paperFragment -> setCurrentFragment(viewModel.frags[1])
            }
            true
        }



    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_containter_frameLayout,fragment,"currentFragment")
            commit()
        }


}