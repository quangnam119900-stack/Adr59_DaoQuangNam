package com.example.btvn_b6


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)


        val images = listOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4
        )


        recyclerView.layoutManager =
            GridLayoutManager(this,2)


        recyclerView.adapter =
            ImageAdapter(images){ image ->


                val intent =
                    Intent(this, FullImageActivity::class.java)


                intent.putExtra(
                    "image",
                    image
                )


                startActivity(intent)

            }

    }
}