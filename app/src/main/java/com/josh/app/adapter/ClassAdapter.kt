package com.josh.app.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.josh.app.data.model.ClassModel
import com.josh.app.databinding.ImageTextLayoutBinding

class ClassAdapter: RecyclerView.Adapter<ImageTextViewholder>() {
    private val list = ArrayList<ClassModel>()

    fun setData(list: List<ClassModel>?){
        list?.let{
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageTextViewholder {
        val binding = ImageTextLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageTextViewholder(binding)
    }

    override fun onBindViewHolder(holder: ImageTextViewholder, position: Int) {
        Log.i(TAG, "onBindViewHolder: Item Loaded$position")
        with(holder){
            with(list[position]){
                Glide.with(holder.itemView.context)
                    .load(imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(binding.imgIcon)
                binding.tvContentName.text = name
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    
    companion object{
        private const val TAG = "ClassAdapter"
    }
}