package com.aniket.e_commerceapp.ui.product.adapter

import com.aniket.e_commerceapp.data.model.ProductAttribute
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aniket.e_commerceapp.databinding.ItemColorBinding
import com.squareup.picasso.Picasso

class ColorAdapter(
    private val list: List<ProductAttribute>
) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    inner class ColorViewHolder(
        val binding: ItemColorBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ColorViewHolder {

        return ColorViewHolder(
            ItemColorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ColorViewHolder,
        position: Int
    ) {

        holder.binding.tvColor.text =
            list[position].value

        Picasso.get()
            .load(list[position].swatchUrl)
            .fit()
            .centerCrop()
            .into(holder.binding.ivColor)
    }

    override fun getItemCount() = list.size
}