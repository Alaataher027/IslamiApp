package com.example.islamiapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityMainBinding
import com.example.islamiapp.databinding.FragmentSebhaBinding
import com.example.islamiapp.ui.main.tabs.hadith.hadith_fragment
import com.example.islamiapp.ui.main.tabs.quran.quran_fragment
import com.example.islamiapp.ui.main.tabs.radio.radio_fragment
import com.example.islamiapp.ui.main.tabs.sebha.sebha_fragment
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.content
            .bottomNavBar.setOnItemSelectedListener(
                object :NavigationBarView.OnItemSelectedListener{
                    override fun onNavigationItemSelected(item: MenuItem): Boolean {
                        when(item.itemId){
                            R.id.navigation_quran->{
                                showTap(quran_fragment())

                            }
                            R.id.navigation_hadith->{
                                showTap(hadith_fragment())

                            }
                            R.id.navigation_sebha->{
                                showTap(sebha_fragment())

                            }
                            R.id.navigation_radio->{
                                showTap(radio_fragment())

                            }
                        }

                        return true // item selected
                    }
                }
            )

        viewBinding.content.bottomNavBar.selectedItemId = R.id.navigation_quran
    }



    private fun showTap(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}