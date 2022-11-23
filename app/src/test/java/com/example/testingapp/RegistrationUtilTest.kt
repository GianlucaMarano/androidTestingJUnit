package com.example.testingapp


import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class RegistrationUtilTest {
    /**
     * La registrazione non va a buon fine se...
     * ...username è vuoto
     * ...password è vuoto
     * ...passwordConfirm è vuoto
     * ...password e passwordConfirm non corrispondono
     * ...se username è già usato
     * ...se username contiene degli spazi interni
     * ...se password non contiene 8 caratteri
     * ...se password non contiene una lettera maiuscola
     * ...se password non contiene un carattere speciale
     * ...se password non contiene una lettere minuscola
     * ...se password non cintiene un numero
     *
     * La registrazione va a buon fine se...
     * ...username corretto, pw e pwconfirm corretti
     */
    //lateinit indica che la variabile verrà successivamente inizializzata
    private lateinit var ru : RegistrationUtil

    @Before //annotazione necessaria per eseguire questo metodo prima dei test
    fun setup(){
        ru = RegistrationUtil() //inizializzazione di RegistrationUtil
    }

    /**
     * Controllo che la verifica di username funzioni per username vuoto
     * ritorno false
     */
    @Test //annotazione necessaria per eseguire il test
    fun validateUsername_usernameVuoto_returnFalse() {
        //eseguo validate username con stringa vuota
        val result = ru.validateUsername(
            username = ""
        )
        //tramite assert mi accerto che il risultato corrisponda a quello aspettato
        assertThat(result).isFalse()
    }

    /**
     * Controllo che le password corrispondano
     * password errate
     * ritorno atteso false
     */
    @Test
    fun validateRegistration_wrongPasswords_returnFalse(){
        val result = ru.validatePasswordConfirm( //controllo di entrambe le password
            password = "Password1!",
            passwordConfirm = "Pippo123!"
        )
        assertThat(result).isFalse()
    }

    /**
     * Controlla che la registrazione vada a buon fine,
     * username e password corrette,
     * ritorno atteso true
     */
    @Test
    fun validateRegistration_correctParameters_returnTrue() {
        val resultUser = ru.validateUsername(username = "Gianluca")
        val resultPw = ru.validatePassword(password = "Password1!")
        val resultConfirm = ru.validatePasswordConfirm(password = "Password1!", passwordConfirm = "Password1!")
        assertThat(resultUser && resultPw && resultConfirm).isTrue()
    }
}