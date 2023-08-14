package com.example.islamiapp.ui.main.tabs.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.FragmentSebhaBinding

class sebha_fragment: Fragment() {

    private var counter: Int = 0
    var newRotation = 0f

    lateinit var viewBinding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.number.text = counter.toString()

        viewBinding.btn.setOnClickListener {
            counter++
            newRotation++
            viewBinding.number.text = counter.toString()

            updateButtonText()

             // Set the desired rotation angle in degrees
            viewBinding.sep7a.rotation = newRotation
        }
    }

    private fun updateButtonText() {
        if (counter>=30)
        {
            viewBinding.btn.text = getString(R.string.alhamdolellah)
            counter = 0


       }

    }


}