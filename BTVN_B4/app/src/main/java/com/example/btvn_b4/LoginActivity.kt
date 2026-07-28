package com.example.btvn_b4


import android.graphics.Color
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {


    private var passwordVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)



        val edtUsername =
            findViewById<EditText>(R.id.edtUsername)


        val edtPassword =
            findViewById<EditText>(R.id.edtPassword)


        val btnLogin =
            findViewById<Button>(R.id.btnLogin)


        val tvError =
            findViewById<TextView>(R.id.tvError)


        val imgEye =
            findViewById<ImageView>(R.id.imgEye)





        // Xử lý đăng nhập

        btnLogin.setOnClickListener {


            val username =
                edtUsername.text.toString().trim()


            val password =
                edtPassword.text.toString().trim()



            if(username == "admin" && password == "123456") {



                tvError.text =
                    "Đăng nhập thành công!"


                tvError.setTextColor(
                    Color.GREEN
                )


                tvError.visibility =
                    TextView.VISIBLE



            } else {



                tvError.text =
                    "Sai tài khoản hoặc mật khẩu!"


                tvError.setTextColor(
                    Color.RED
                )


                tvError.visibility =
                    TextView.VISIBLE


            }


        }





        // Ẩn lỗi khi nhập lại Username

        edtUsername.setOnFocusChangeListener { _, focus ->


            if(focus){

                tvError.visibility =
                    TextView.GONE

            }


        }





        // Ẩn lỗi khi nhập lại Password

        edtPassword.setOnFocusChangeListener { _, focus ->


            if(focus){

                tvError.visibility =
                    TextView.GONE

            }


        }





        // Hiện / ẩn mật khẩu

        imgEye.setOnClickListener {



            passwordVisible =
                !passwordVisible




            if(passwordVisible){



                edtPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()



            }else{



                edtPassword.transformationMethod =
                    PasswordTransformationMethod.getInstance()



            }



            edtPassword.setSelection(
                edtPassword.text.length
            )


        }


    }


}