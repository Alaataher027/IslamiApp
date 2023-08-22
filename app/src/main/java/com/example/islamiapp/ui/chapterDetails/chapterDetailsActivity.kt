package com.example.islamiapp.ui.chapterDetails

import android.os.Bundle
import android.provider.SyncStateContract.Constants
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.databinding.ActivityChapterDetailsBinding
import com.example.islamiapp.ui.constants
import java.util.zip.Inflater

// بنستقبل ال parameters
class chapterDetailsActivity : AppCompatActivity(){

    lateinit var viewBinding: ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initParams()
        initViews()
        loadChapterFile()
    }

    private fun initViews() {
        // back button
        setSupportActionBar(viewBinding.toolar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        // view sura name
        viewBinding.titleSura.text = chapterName

        // remove app name from app bar
        supportActionBar?.title=""
    }

    // back button
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun loadChapterFile() {
        val fileContent =
            assets.open("$chapterIndex.txt").bufferedReader().use{it.readText()}

        // بقرا كل سطر لوحده:
        val lines = fileContent.trim().split("/n")
        bindService(lines)

    }

    lateinit var adapter: versesAdapter

    private fun bindService(verses: List<String>) {
        adapter = versesAdapter(verses)
        viewBinding.content.RVVerse.adapter = adapter
    }


    lateinit var chapterName : String
    var chapterIndex:Int = 0
    private fun initParams() {
        chapterName = intent.getStringExtra(constants.EXTRA_CAPTER_NAME)?:""
        chapterIndex = intent.getIntExtra(constants.EXTRA_CAPTER_INDEX, 0)
    }


}