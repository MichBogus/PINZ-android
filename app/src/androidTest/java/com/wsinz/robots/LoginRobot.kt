package com.wsinz.robots

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.codefirst.bdd.gherkinatorbdd.GherkinatorRobot
import com.codefirst.bdd.gherkinatorbdd.model.And
import com.codefirst.bdd.gherkinatorbdd.model.Then
import com.codefirst.bdd.gherkinatorbdd.model.When
import com.wsinz.R

class LoginRobot : GherkinatorRobot() {

    @When("I can see LoginActivity")
    fun assertLoginActivityOpen() {

    }

    @Then("I can see login button")
    fun assertLoginButtonVisible() {
        onView(withId(R.id.login_button))
                .check(matches(isDisplayed()))
    }

    @And("I can see register user button")
    fun assertRegisterUserButtonVisible() {
        onView(withId(R.id.register_user))
                .check(matches(isDisplayed()))
    }

    @And("I can see register company button")
    fun assertRegisterCompanyButtonVisible() {
        onView(withId(R.id.register_company))
                .check(matches(isDisplayed()))
    }

    @And("I can see login field")
    fun assertLoginFieldVisible() {
        onView(withId(R.id.username_input))
                .check(matches(isDisplayed()))
    }

    @And("I can see password field")
    fun assertPasswordFieldVisible() {
        onView(withId(R.id.password_input))
                .check(matches(isDisplayed()))
    }
}