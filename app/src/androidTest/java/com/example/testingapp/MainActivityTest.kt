package com.example.testingapp

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers.not

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Test della UI per la registrazione
 */
@LargeTest //per i test ui che richiedono molto tempo >1s
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    //scenario gestisce l'activity e il suo ciclo di vita per il test
    private lateinit var scenario: ActivityScenario<MainActivity>
    //dichirazione del decorView per accedere al Toast
    private lateinit var decorView : View

    @Before //Da utilizzare per le operazioni prima del test
    fun setup(){
        //inizializzazione dello scenario
        scenario = ActivityScenario.launch(MainActivity::class.java) //rispettare notazione ::class.java
        scenario.moveToState(Lifecycle.State.RESUMED) //comandiamo lo stato della activity
        //onActivity richiama operazioni da svolgere all'interno dell'activity
        scenario.onActivity {
            //inizializzazione di decorView
            decorView = it.window.decorView
        }
    }

    /**
     * verifica la registrazione compilando correttamente l'input del form
     * mostra registrazione completata
     */
    @Test//da inserire prima di ogni metodo di test
    fun correctInputRegistration_showRegistrationCompleted() {
        //onView permette di selezionare un elemento in base ad una caratteristica
        //withId/withText sono dei viewmatcher cioè quelle caratteristiche che ci permettono di identificare una view
        //perform è il comando che ci permette di compiere un'azione sull'elemento (click, longClick, doubleClick, typeText)
        onView(withId(R.id.username_main)).perform(typeText("Gianluca"))
        onView(withId(R.id.password_main)).perform(typeText("Password1!"))
        onView(withId(R.id.pw_confirm_main)).perform(typeText("Password1!"), closeSoftKeyboard())
        onView(withId(R.id.registration_btn_main)).perform(click())
        //in caso di textView con registrazione completata
        //onView(withId(R.id.idtextview)).check(matches(isDisplayed()))

        //check che il toast venga mostrato
        onView(withText(R.string.registration_completed))
            .inRoot(withDecorView(not(decorView)))
            .check(matches(isDisplayed()))
    }
}