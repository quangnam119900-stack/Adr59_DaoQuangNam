package com.example.btvn_b7

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var imgAvatar: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView

    private var name = "Albert Florest"
    private var email = "albertflorest@email.com"
    private var gender = "Male"
    private var phone = "+44 1632 960860"
    private var address = "314, St No 22 - Dwalington Street"



    private val pickImageLauncher =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->

            if (uri != null) {

                imgAvatar.setImageURI(uri)

                getSharedPreferences(
                    "profile",
                    MODE_PRIVATE
                )
                    .edit()
                    .putString(
                        "avatar_uri",
                        uri.toString()
                    )
                    .apply()
            }
        }




    private val editProfileLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {

                val data = result.data ?: return@registerForActivityResult

                name = data.getStringExtra("name") ?: name
                email = data.getStringExtra("email") ?: email
                gender = data.getStringExtra("gender") ?: gender
                phone = data.getStringExtra("phone") ?: phone
                address = data.getStringExtra("address") ?: address

                updateProfileUI()
            }
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)


        imgAvatar = findViewById(R.id.imgAvatar)
        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvPhone = findViewById(R.id.tvPhone)


        loadSavedAvatar()

        updateProfileUI()




        findViewById<Button>(
            R.id.btnEditProfile
        ).setOnClickListener {

            val intent = Intent(
                this,
                EditProfileActivity::class.java
            )

            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("gender", gender)
            intent.putExtra("phone", phone)
            intent.putExtra("address", address)

            editProfileLauncher.launch(intent)
        }




        findViewById<Button>(
            R.id.btnEditAvatar
        ).setOnClickListener {

            pickImageLauncher.launch("image/*")
        }
    }




    private fun updateProfileUI() {

        tvName.text = name
        tvEmail.text = email
        tvPhone.text = phone
    }



    private fun loadSavedAvatar() {

        val avatarUri = getSharedPreferences(
            "profile",
            MODE_PRIVATE
        ).getString(
            "avatar_uri",
            null
        )

        if (!avatarUri.isNullOrEmpty()) {

            imgAvatar.setImageURI(
                Uri.parse(avatarUri)
            )
        }
    }
}