package com.example.testingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() { //dichiarazione della classe Main che estende AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) { //Primo metodo chiamato nel ciclo di vita di Activity
        super.onCreate(savedInstanceState) //chiamata al super di onCreate
        setContentView(R.layout.activity_main) //metodo di activity che collega xml e activity
        //dichiarazione delle view
        val usernameEt : EditText = findViewById(R.id.username_main) //findviewbyid è un metodo di activity che identifica una view tramite l'id dichiarato nel xml
        val passwordEt : EditText = findViewById(R.id.password_main)
        val pwConfirmEt: EditText = findViewById(R.id.pw_confirm_main)
        val registrationBtn : Button = findViewById(R.id.registration_btn_main)
        //comportamento al click del pulsante registrationBtn
        //viene passato un oggetto che implementa View.OnClickListener
        registrationBtn.setOnClickListener {
            usernameEt.error = null //reset degli errori per gli EditText
            passwordEt.error = null
            val util = RegistrationUtil() //Instanziamento oggetto RegistrationUtil (per verificare la correttezza degli input)
            val resultUser = util.validateUsername(usernameEt.text.toString()) //verifica username valido
            val resultPassword = util.validatePassword(passwordEt.text.toString()) //verifica password valida
            //val resultPassword = util.validarePassword(passwordEt.text.toString() )
            //resultPassword util.validatePassword

            if (resultUser){//controllo risultato username
                //se username è valido (true) controllo risultato password
                if(resultPassword){
                    //se password è valida completo la registrazione
                    Toast.makeText( //creazione toast, metodo statico
                        this, //il context è contenuto in activity quindi passo this che corrisponde all'istanza corrente
                        //"Registrazione Completata", //il testo che vogliamo mostrare
                        resources.getString(R.string.registration_completed), //se volessimo usare una risorsa di strings
                        Toast.LENGTH_LONG) //intero che definisce la durata del toast
                        .show() //metodo necessario per visualizzare il toast
                }else{
                    //se password non è valida mostro messaggio di errore su password
                    passwordEt.error = "La password deve essere lunga almeno 8 caratteri, avere una lettera maiuscola, un numero e carattere speciale"
                }
            }else{//se username non è valido mostro messaggio di errore
                usernameEt.error = "Username vuoto oppure sbagliato"
            }
        }
    }
}