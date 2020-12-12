package com.rozetka.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

import static com.rozetka.pages.pageUtils.PagesProvider.getHomePage;
import static com.rozetka.pages.pageUtils.PagesProvider.getSighUpPage;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SignUpSteps {

    @And("I click on the {string} button")
    public void clickEnterAccountButton(String linkText) {
        getHomePage.clickPersonalAccount(linkText);
    }

    @And("I click on the {string} link")
    public void clickSignUpLink(String signUpLink) {
        getSighUpPage.clickRegistrationLink(signUpLink);
    }

    @When("I enter the {string} into the Sign Up's {string} field with {string} label")
    public void fillSignUpFields(String usersData, String fieldSetName, String inputLabelName) {
        getSighUpPage.enterUsersData(fieldSetName, inputLabelName, usersData);
        log.info(usersData);
    }

    @Then("I should see the warning message {string} under the {string} field")
    public void checkWarningMessage(String expectedWarning, String fieldSetName) {
        assertThat(getSighUpPage.getActualWarningMessage(fieldSetName).equals(expectedWarning))
                .overridingErrorMessage("The message is not correct.")
                .isTrue();
        log.warn(getSighUpPage.getActualWarningMessage(fieldSetName));
    }
}
