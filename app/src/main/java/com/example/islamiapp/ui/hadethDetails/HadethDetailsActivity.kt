package com.example.islamiapp.ui.hadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.databinding.ActivityHadethDetailsBinding
import com.example.islamiapp.ui.constants
import com.example.islamiapp.ui.model.Hadeth

class HadethDetailsActivity:AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
        initParams()
        bindHadeth()

    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = null
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun bindHadeth() {
        viewBinding.titleHadeth.text = hadeth?.title
        viewBinding.content.content.text = hadeth?.content

    }

    var hadeth:Hadeth? = null
    private fun initParams() {
        // for new versions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getSerializableExtra(constants.EXTRA_HADETH, Hadeth::class.java) // cast
        }else {

            // for old version
            hadeth = intent.getSerializableExtra(constants.EXTRA_HADETH) as Hadeth // cast

        }

    }
}