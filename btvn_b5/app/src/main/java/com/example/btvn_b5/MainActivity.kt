package com.example.btvn_b5


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    private lateinit var imageView: ImageView
    private lateinit var btnNext: Button
    private lateinit var btnBack: Button


    private val images = arrayOf(
        R.drawable.anh1,
        R.drawable.anh2,
        R.drawable.anh3
    )


    private var currentIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        imageView = findViewById(R.id.imageView)
        btnNext = findViewById(R.id.btnNext)
        btnBack = findViewById(R.id.btnBack)


        showImage()


        btnNext.setOnClickListener {

            if (currentIndex < images.size - 1) {

                currentIndex++

                showImage()

            }

        }


        btnBack.setOnClickListener {

            if (currentIndex > 0) {

                currentIndex--

                showImage()

            }

        }


        updateButton()

    }


    private fun showImage(){

        imageView.setImageResource(images[currentIndex])

        updateButton()

    }


    private fun updateButton(){



        btnBack.visibility =
            if(currentIndex == 0)
                Button.INVISIBLE
            else
                Button.VISIBLE




        btnNext.visibility =
            if(currentIndex == images.size - 1)
                Button.INVISIBLE
            else
                Button.VISIBLE

    }


}