package com.example.testingapp

/**
 * Classe verifica la correttezza di username e password per l'input di registrazioni
 */
class RegistrationUtil {

    /**
     * La registrazione non va a buon fine se...
     * ...username è vuoto
     * ...se username è già usato
     * ...se username contiene degli spazi interni
     * ...password è vuoto
     * ...passwordConfirm è vuoto
     * ...se password non contiene 8 caratteri
     * ...se password non contiene una lettera maiuscola
     * ...se password non contiene un carattere speciale
     * ...se password non contiene una laettere minuscola
     * ...se password non cintiene un numero
     *
     * ...password e passwordConfirm non corrispondono
     * La registrazione va a buon fine se...
     * ...username corretto, pw e pwconfirm corretti
     */
    private val usernames = listOf("Luca", "Paolo") //mockup per verificare che l'utente non sia già inserito



    /**
     * Verifica Username non va a buon fine se...
     * ...username è vuoto
     * ...se username è già usato
     * ...se username contiene degli spazi interni
     */
    fun validateUsername(
        username: String
    ): Boolean {
        val user = username.trim()//elimina gli spazi vuoti prima e dopo il testo in una stringa
        if (user.isNotBlank()) {//verifica che la stringa non sia vuota o composta da soli spazi vuoti
            if (user.contains(' ')) {//verifica che la stringa non abbia altri spazi vuoti all'interno
                return false //se contiene spazi vuoti ritorno false
            }
            if (usernames.contains(user)) {
                //se la stringa è uguale a uno già inserito ritorno false
                return false
            }
            return true
        } else {
            return false
        }
    }

    /**
     * Verifica Password non va a buon fine se...
     * ...password è vuoto
     * ...passwordConfirm è vuoto
     * ...se password non contiene 8 caratteri
     * ...se password non contiene una lettera maiuscola
     * ...se password non contiene un carattere speciale
     * ...se password non contiene una laettere minuscola
     * ...se password non cintiene un numero
     */
    fun validatePassword(
        password: String //input password
    ): Boolean {
        val pw = password.trim() //elimina gli spazi vuoti prima e dopo il testo in una stringa
        if (pw.isNotBlank()) { //verifica che la stringa non sia vuota o composta da soli spazi vuoti
            //controllo con espressione per verificare che la password sia correttamente formattata
            if (!pw.matches(Regex("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$"))) {
                //se non corrisponde ritorno false
                return false
            }
            return true //se tutto è corretto ritorno true
        }else{
            //se la stringa è composta da soli spazi vuoti o è vuota ritorno false
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