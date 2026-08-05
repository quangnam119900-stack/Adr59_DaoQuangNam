package com.example.btvn_b6


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView



class ImageAdapter(
    private val images: List<Int>,
    private val onClick:(Int)->Unit
)
    : RecyclerView.Adapter<ImageAdapter.ViewHolder>(){


    class ViewHolder(view: View)
        : RecyclerView.ViewHolder(view){

        val image: ImageView =
            view.findViewById(R.id.imageView)

    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {


        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_image,
                    parent,
                    false
                )


        return ViewHolder(view)

    }



    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {


        val img = images[position]


        holder.image.setImageResource(img)


        holder.itemView.setOnClickListener {

            onClick(img)

        }

    }



    override fun getItemCount(): Int {

        return images.size

    }

}