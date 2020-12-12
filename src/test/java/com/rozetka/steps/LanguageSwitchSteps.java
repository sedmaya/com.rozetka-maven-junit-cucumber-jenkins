package com.rozetka.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

import static com.rozetka.pages.pageUtils.PagesProvider.getHomePage;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class LanguageSwitchSteps {
    /*private static final Logger logger = LogManager
            .getLogger(LanguageSwitchSteps.class);*/

    @When("I click on {string} link")
    public void iClickOnLink(String languageName) {
        getHomePage.clickLanguageLink(languageName);
    }

    @Then("I should see the URL {string}")
    public void iShouldSeeTheURL(String expectedLanguageUrl) {
        assertThat(getHomePage.currentURL()).isEqualTo(expectedLanguageUrl)
                .as("The URL is not as expected.", expectedLanguageUrl);
        log.info(getHomePage.currentURL());
    }

    @And("I should see {string} text in a Search Bar's placeholder")
    public void iSeeExpectedPlaceholdersText(String expectedLanguageText) {
        assertThat(getHomePage.isSearchBarPlaceholderTextDisplayed(expectedLanguageText))
                .overridingErrorMessage("The language text is not as expected")
                .isTrue();
    }

}
