package com.example.btvn_b6


import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity



class FullImageActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_full_image)


        val imageView =
            findViewById<ImageView>(R.id.fullImage)


        val image =
            intent.getIntExtra(
                "image",
                0
            )


        imageView.setImageResource(image)

    }

}