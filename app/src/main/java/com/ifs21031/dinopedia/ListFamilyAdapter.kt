package com.ifs21031.dinopedia

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21031.dinopedia.databinding.ItemRowFamilyBinding

class ListFamilyAdapter (private val listFamily: ArrayList<Family>) : RecyclerView.Adapter<ListFamilyAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback:
                               OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType:
    Int): ListViewHolder {
        val binding =
            ItemRowFamilyBinding.inflate(LayoutInflater.from(viewGroup.context),
                viewGroup, false)
        return ListViewHolder(binding)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position:
    Int) {
        val fruit = listFamily[position]
        holder.binding.ivItemFamily.setImageResource(fruit.icon)
        holder.binding.tvItemFamily.text = fruit.name
        holder.itemView.setOnClickListener {
            onItemClickCallback
                .onItemClicked(listFamily[holder.adapterPosition])
        }
    }
    override fun getItemCount(): Int = listFamily.size
    class ListViewHolder(var binding: ItemRowFamilyBinding) :
        RecyclerView.ViewHolder(binding.root)
    interface OnItemClickCallback {
        fun onItemClicked(data: Family)
    }
}