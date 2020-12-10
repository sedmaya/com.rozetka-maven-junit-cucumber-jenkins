package com.rozetka.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.rozetka.pages.pageUtils.PagesProvider.getHomePage;
import static org.assertj.core.api.Assertions.assertThat;

public class LanguageSwitchSteps {

    @When("I click on {string} link")
    public void iClickOnLink(String languageName) {
        getHomePage.clickLanguageLink(languageName);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Then("I should see the URL {string}")
    public void iShouldSeeTheURL(String expectedLanguageUrl) {
        assertThat(getHomePage.currentURL()).isEqualTo(expectedLanguageUrl)
                .overridingErrorMessage("The URL is not as expected.");
    }

    @And("I should see {string} text in a Search Bar's placeholder")
    public void iSeeExpectedPlaceholdersText(String expectedLanguageText) {
        assertThat(getHomePage.isSearchBarPlaceholderTextDisplayed(expectedLanguageText))
                .overridingErrorMessage("The language text is not as expected")
                .isTrue();
    }

}
