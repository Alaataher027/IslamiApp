package com.example.islamiapp.ui.main.tabs.hadith

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.FragmentHadithBinding
import com.example.islamiapp.ui.constants
import com.example.islamiapp.ui.hadethDetails.HadethDetailsActivity
import com.example.islamiapp.ui.model.Hadeth

class hadith_fragment : Fragment() {

    lateinit var viewBinding: FragmentHadithBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadithBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

    }

    lateinit var adapter: HadethRecyclerAdapter
    private fun initViews() {
        adapter = HadethRecyclerAdapter(null)
        adapter.onItemClickListener = HadethRecyclerAdapter.OnItemClickListener{
            pos, hadeth ->
            showHadethDetails(hadeth)
        }
        viewBinding.rvHadeth.adapter = adapter
    }

    private fun showHadethDetails(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(constants.EXTRA_HADETH, hadeth)
        startActivity(intent)

    }

    override fun onStart() {
        super.onStart()
        loadHadethFile() ////
        bindHadethList()

    }

    private fun bindHadethList() {
        adapter.bindItems(hadethList)
    }

    val hadethList = mutableListOf<Hadeth>()
    private fun loadHadethFile() {
        val fileContent =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use{it.readText()}
        val singleHadethList = fileContent.trim().split("#")
        singleHadethList.forEach{element->
            val lines = element.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
            //joinToString()>> بتجمع ال ليست فى استرينج واحد
        }

// requireActivity()>> عشان انا واقفة فى  fragment
// requireActivity() >> عشان استدعيها لازم ابقى متأكده ان ال
//                   fragment  ظاهرة فى الميموري
// loadHadethFile()  عشان كده هنادى على ال
// فى ال onStart
    }

}