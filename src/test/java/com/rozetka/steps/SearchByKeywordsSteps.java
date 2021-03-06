package com.rozetka.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;

import static com.rozetka.pages.pageUtils.PagesProvider.getIphone12Page;
import static com.rozetka.pages.pageUtils.PagesProvider.getSearchResultsPage;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SearchByKeywordsSteps {

    @And("I see the list of searched item that contain the following keywords")
    public void isListContainsSearchedKeywords(String searchKeywords) {
        for (WebElement el : getSearchResultsPage.getSearchedItemList()) {
            String s = el.getText();
            assertThat(s.contains(searchKeywords))
                    .overridingErrorMessage
                            ("All or some items titles in the list do not contain the keywords!")
                    .isTrue();
            log.info(s);
        }
        log.info(getSearchResultsPage.getSearchedItemList());
    }

    @When("I click on the very first item in the search results list")
    public void clickOnFirstSearchedItem() {
        getSearchResultsPage.clickFirstSearchedItem();
    }

    @Then("I should see the searched following keywords in a PDP heading")
    public void iShouldSeeTheSearchedKeywordsInTitle(String searchKeywords) {
        assertThat(getIphone12Page.getItemsPdpTitle().contains(searchKeywords))
                .as("The title does not contain the searched keywords.")
                .isTrue();
        log.info(searchKeywords);
    }
}
