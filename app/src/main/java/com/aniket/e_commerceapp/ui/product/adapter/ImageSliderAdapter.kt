package com.aniket.e_commerceapp.ui.product.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.aniket.e_commerceapp.R
import com.squareup.picasso.Picasso

class ImageSliderAdapter(
    private val images: List<String>
) : RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_slider_image, parent, false)

        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ImageViewHolder,
        position: Int
    ) {

        Picasso.get()
            .load(images[position])
            .fit()
            .centerInside()
            .into(holder.image)
    }

    override fun getItemCount() = images.size
}