package com.rozetka.steps;

import io.cucumber.java.en.Then;

import static com.rozetka.pages.pageUtils.PagesProvider.*;
import static org.assertj.core.api.Assertions.*;

public class NoSearchResultsSteps {

    @Then("I should see the page with text {string}")
    public void iShouldSeeThePageWithText(String expectedMessage) {
        assertThat(getSearchResultsPage.noSearchResultsMessage().equals(expectedMessage))
                .overridingErrorMessage("The Search results are not as expected")
                .isTrue();
    }
}
