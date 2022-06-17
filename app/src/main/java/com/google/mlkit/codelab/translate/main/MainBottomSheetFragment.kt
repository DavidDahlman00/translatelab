package com.google.mlkit.codelab.translate.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.mlkit.codelab.translate.R
import com.google.mlkit.codelab.translate.databinding.FragmentMainBottomSheetBinding
import androidx.lifecycle.Observer


class MainBottomSheetFragment(fragment: MainFragment, viewModel: MainViewModel) : BottomSheetDialogFragment() {

    private lateinit var mainBottomSheetBinding : FragmentMainBottomSheetBinding
    private  val fragment = fragment
    private  val viewModel = viewModel
    lateinit var recyclerView: RecyclerView
    private var adapter : RecyclerView.Adapter<MainAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_bottom_sheet, container, false)
        val binding = FragmentMainBottomSheetBinding.bind(view)
        mainBottomSheetBinding = binding

        recyclerView = mainBottomSheetBinding.myrecyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = MainAdapter(viewModel, this)
        recyclerView.adapter = adapter
        viewModel.tanslatedList.observe(viewLifecycleOwner, Observer { recyclerView.adapter?.notifyDataSetChanged()})
        recyclerView.adapter?.notifyDataSetChanged()
        return view
    }

}