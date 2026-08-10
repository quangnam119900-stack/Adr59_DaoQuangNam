package com.example.btvn_b7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_profile)

        edtName = findViewById(R.id.edtName)
        edtEmail = findViewById(R.id.edtEmail)
        edtPhone = findViewById(R.id.edtPhone)

        val btnSave = findViewById<Button>(R.id.btnSave)

        edtName.setText(intent.getStringExtra("name"))
        edtEmail.setText(intent.getStringExtra("email"))
        edtPhone.setText(intent.getStringExtra("phone"))

        btnSave.setOnClickListener {

            val resultIntent = Intent()

            resultIntent.putExtra(
                "name",
                edtName.text.toString()
            )

            resultIntent.putExtra(
                "email",
                edtEmail.text.toString()
            )

            resultIntent.putExtra(
                "phone",
                edtPhone.text.toString()
            )

            resultIntent.putExtra(
                "gender",
                intent.getStringExtra("gender")
            )

            resultIntent.putExtra(
                "address",
                intent.getStringExtra("address")
            )

            setResult(RESULT_OK, resultIntent)

            finish()
        }
    }
}