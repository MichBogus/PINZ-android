package com.wsinz.gherkin

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.codefirst.bdd.gherkinatorbdd.GherkinatorEngine
import com.codefirst.bdd.gherkinatorbdd.GherkinatorRobot
import com.codefirst.bdd.gherkinatorbdd.model.ScenarioTest
import com.wsinz.login.presentation.LoginActivity
import com.wsinz.robots.ApplicationRobot
import com.wsinz.robots.LoginRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginViewFeatureTest : GherkinatorEngine(InstrumentationRegistry.getContext()) {

    override var robots: MutableList<GherkinatorRobot>? = null

    override fun featureFileLocation(): String = "loginView.feature"

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(LoginActivity::class.java, false, false)

    @Before
    fun setUp() {
        robots = mutableListOf(LoginRobot(),
                ApplicationRobot(activityRule))
    }

    @Test
    @ScenarioTest("I can see all controls for login view")
    fun checkingControlsForLoginView() {
        runScenario()
    }


}