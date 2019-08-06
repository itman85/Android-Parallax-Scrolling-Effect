package com.phannguyen.parallaxsample.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.phannguyen.parallaxsample.MyGlideModule
import com.phannguyen.parallaxsample.R

class GalleryAdapter(context:Context, private val data: List<Int>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder{
        return ImageViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position in 0 until data.size)
            (holder as ImageViewHolder).bind(data[position])
    }

    private class ImageViewHolder(inflater: LayoutInflater,parent: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.gallery_item,parent,false)){
        private val imageView = itemView.findViewById<ImageView>(R.id.image_view)
        fun bind(resId:Int){
           imageView.setImageResource(resId)
        }

    }
}