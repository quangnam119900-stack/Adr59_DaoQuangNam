package com.example.btvn_b7

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imgAvatar: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView


    private val pickImageLauncher =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->

            if (uri != null) {
                imgAvatar.setImageURI(uri)
            }
        }


    private val editProfileLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {

                val data = result.data

                if (data != null) {

                    tvName.text =
                        data.getStringExtra("name") ?: tvName.text

                    tvEmail.text =
                        data.getStringExtra("email") ?: tvEmail.text

                    tvPhone.text =
                        data.getStringExtra("phone") ?: tvPhone.text
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        imgAvatar = findViewById(R.id.imgAvatar)
        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvPhone = findViewById(R.id.tvPhone)

        val btnEditAvatar =
            findViewById<Button>(R.id.btnEditAvatar)

        val btnEditProfile =
            findViewById<Button>(R.id.btnEditProfile)




        btnEditAvatar.setOnClickListener {

            pickImageLauncher.launch("image/*")
        }




        btnEditProfile.setOnClickListener {

            val intent =
                Intent(this, EditProfileActivity::class.java)

            // Truyền dữ liệu hiện tại sang màn Edit
            intent.putExtra(
                "name",
                tvName.text.toString()
            )

            intent.putExtra(
                "email",
                tvEmail.text.toString()
            )

            intent.putExtra(
                "phone",
                tvPhone.text.toString()
            )

            editProfileLauncher.launch(intent)
        }
    }
}