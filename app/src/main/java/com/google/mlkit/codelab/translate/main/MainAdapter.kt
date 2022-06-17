package com.google.mlkit.codelab.translate.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import com.google.mlkit.codelab.translate.R
import com.google.mlkit.codelab.translate.data.TranslateList
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter(viewModel: MainViewModel, mainBottomSheetFragment: MainBottomSheetFragment) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val viewModel = viewModel
    private val mainBottomSheetFragment = mainBottomSheetFragment

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("test recycler", "test")
        holder.itemView.also {
            it.list_item_text1.text =
                //viewModel.tanslatedList.value?.get(position)?.textToTranslate ?: "error"
                TranslateList.list[position].textToTranslate
            it.list_item_text2.text =
                //viewModel.tanslatedList.value?.get(position)?.translatedText ?: "error"
                TranslateList.list[position].translatedText
            it.list_item_remove.setOnClickListener {
               // viewModel.removeTranslateItem( position)
                TranslateList.removeAt(position).also {
                    mainBottomSheetFragment.recyclerView.adapter?.notifyItemRemoved(position) }
                Log.d("remove item", position.toString())

            }
        }
    }

    override fun getItemCount(): Int {
        Log.d("test recycler count", "test")
      /*  var length = 0
        viewModel.tanslatedList.observe(mainBottomSheetFragment.viewLifecycleOwner, Observer {
            length = viewModel.tanslatedList.value?.size ?: 0
        })
        return length
        */
        return TranslateList.list.size
    }
}