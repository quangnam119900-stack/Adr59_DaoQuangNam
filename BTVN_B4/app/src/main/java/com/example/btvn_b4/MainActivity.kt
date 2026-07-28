package com.example.btvn_b4


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        // Nút mở app đọc sách

        val btnBook = findViewById<Button>(R.id.btnBook)



        // Nút mở Diary

        val btnDiary = findViewById<Button>(R.id.btnDiary)



        // Nút mở Login

        val btnLogin = findViewById<Button>(R.id.btnLogin)





        btnBook.setOnClickListener {


            val intent = Intent(

                this,

                ReadBookActivity::class.java

            )


            startActivity(intent)


        }





        btnDiary.setOnClickListener {


            val intent = Intent(

                this,

                DiaryActivity::class.java

            )


            startActivity(intent)


        }





        btnLogin.setOnClickListener {


            val intent = Intent(

                this,

                LoginActivity::class.java

            )


            startActivity(intent)


        }



    }


}