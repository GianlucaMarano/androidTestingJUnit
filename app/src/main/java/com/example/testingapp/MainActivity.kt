package com.example.testingapp

import android.content.res.Resources.Theme
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val usernameEt : EditText = findViewById(R.id.username_main)
        val passwordEt : EditText = findViewById(R.id.password_main)
        val pwConfirmEt: EditText = findViewById(R.id.pw_confirm_main)
        val registrationBtn : Button = findViewById(R.id.registration_btn_main)
        val registrationErrorTv : TextView = findViewById(R.id.registration_error_main)

        registrationBtn.setOnClickListener {
            usernameEt.error = null
            passwordEt.error = null
            val util = RegistrationUtil()
            val resultUser = util.validateUsername(usernameEt.text.toString())
            val resultPassword = util.validatePassword(passwordEt.text.toString())
            //val resultPassword = util.validarePassword(passwordEt.text.toString() )
            //resultPassword util.validatePassword

            if (resultUser){
                if(resultPassword){
                    Toast.makeText(this,"Registrazione Completata", Toast.LENGTH_LONG).show()
                }else{
                    passwordEt.error = "La password deve essere lunga almeno 8 caratteri, avere una lettera maiuscola, un numero e carattere speciale"
                }
            }else{
                usernameEt.error = "Username vuoto oppure sbagliato"
            }
        }
    }
}