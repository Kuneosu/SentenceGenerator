package com.kks.customfont_ex

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kks.customfont_ex.databinding.RecyclerItemBinding

private const val TAG = "RECYCLE_TEST"

class SentenceAdapter(list: MutableList<String>) :
    ListAdapter<String, SentenceAdapter.ViewHolder>(DiffCallback()) {
    private lateinit var binding: RecyclerItemBinding
    private val sentenceList = list


    class ViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(text: String) {
            Log.d(TAG, "bind() called with: text = $text")
            binding.recyclerText.text = text
        }
    }

    fun addItem(sentence: String){
        sentenceList.add(sentence)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder() called with: parent = $parent, viewType = $viewType")
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder() called with: holder = $holder, position = $position")
        holder.bind(sentenceList[position])
    }

    override fun getItemCount() = sentenceList.size
}


class DiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        Log.d(TAG, "areItemsTheSame() called with: oldItem = $oldItem, newItem = $newItem")
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        Log.d(TAG, "areContentsTheSame() called with: oldItem = $oldItem, newItem = $newItem")
        return oldItem == newItem
    }
}

//class SentenceAdapter(list: MutableList<String>) :
//    RecyclerView.Adapter<SentenceAdapter.ViewHolder>() {
//
//    private lateinit var binding: RecyclerItemBinding
//    private var sentenceList = list
//
//    class ViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(text: String) {
//            binding.recyclerText.text = text
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SentenceAdapter.ViewHolder {
//        binding = DataBindingUtil.inflate(
//            LayoutInflater.from(parent.context),
//            R.layout.recycler_item,
//            parent,
//            false
//        )
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: SentenceAdapter.ViewHolder, position: Int) {
//        holder.bind(sentenceList[position])
//    }
//
//    override fun getItemCount() = sentenceList.size
//
//
//}