package com.wsinz.robots

import android.support.test.rule.ActivityTestRule
import android.support.v7.app.AppCompatActivity
import com.codefirst.bdd.gherkinatorbdd.GherkinatorRobot
import com.codefirst.bdd.gherkinatorbdd.model.Given

class ApplicationRobot<T : AppCompatActivity>(private val activityTestRule: ActivityTestRule<T>) : GherkinatorRobot() {

    @Given("I open application")
    fun assertOpeningApplication() {
        activityTestRule.launchActivity(null)
    }
}