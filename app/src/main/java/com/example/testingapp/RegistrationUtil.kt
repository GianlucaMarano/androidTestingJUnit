package com.example.testingapp

class RegistrationUtil {
    /**
     * La registrazione non va a buon fine se...
     * ...username è vuoto
     * ...se username è già usato
     * ...se username contiene degli spazi interni
     * ...password è vuoto
     * ...passwordConfirm è vuoto
     * ...password e passwordConfirm non corrispondono
     * ...se password non contiene 8 caratteri
     * ...se password non contiene una lettera maiuscola
     * ...se password non contiene un carattere speciale
     * ...se password non contiene una laettere minuscola
     * ...se password non cintiene un numero
     *
     * La registrazione va a buon fine se...
     * ...username corretto, pw e pwconfirm corretti
     */
    val usernames = listOf("Luca", "Paolo")

    fun validateRegistration(
        username: String,
        password: String,
        passwordConfirm: String
    ): Boolean {
        val user = username.trim()
        val pw = password.trim()
        val pwC = passwordConfirm.trim()
        if (user.isNotBlank() && pw.isNotBlank() && pwC.isNotBlank()) {
            if (user.contains(' ')) {
                return false
            }
            if (usernames.contains(user)) {
                return false
            }
            if (!pw.matches(Regex("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$"))) {
                return false
            }
            if (pw != pwC) {
                return false
            }
            return true
        } else {
            return false
        }
    }

    /**
     * Verifica Username non va a buon fine se...
     * ...username è vuoto
     * ...se username è già usato
     * ...se username contiene degli spazi interni
     */
    fun validateUsername(
        username: String
    ): Boolean {
        val user = username.trim()
        if (user.isNotBlank()) {
            if (user.contains(' ')) {
                return false
            }
            if (usernames.contains(user)) {
                return false
            }
            return true
        } else {
            return false
        }
    }

    fun validatePassword(
        password: String
    ): Boolean {
        val pw = password.trim()
        if (pw.isNotBlank()) {
            if (!pw.matches(Regex("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$"))) {
                return false
            }
            return true
        }else{
            return false
        }
    }

    fun validatePasswordConfirm(
        password: String,
        passwordConfirm: String
    ): Boolean {
        val pw = password.trim()
        val pwC = passwordConfirm.trim()
        if (pw.isNotBlank() && pwC.isNotBlank()) {
            if (pw != pwC) {
                return false
            }
            return true
        }else{
            return false
        }
    }
}