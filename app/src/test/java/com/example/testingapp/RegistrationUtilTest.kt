package com.example.testingapp


import com.google.common.truth.Truth.assertThat
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
    val ru = RegistrationUtil()

    @Test
    fun validateUsername_usernameVuoto_returnFalse() {
        val result = ru.validateUsername(
            username = ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun validateRegistration_correctParameters_returnTrue() {
        val result = ru.validateRegistration(
            username = "Gianluca",
            password = "Password1!",
            passwordConfirm = "Password1!"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun validateRegistration_wrongPasswords_returnFalse(){
        val result = ru.validateRegistration(
            username = "Gianluca",
            password = "Password1!",
            passwordConfirm = "Pippo123!"
        )
        assertThat(result).isFalse()
    }
}