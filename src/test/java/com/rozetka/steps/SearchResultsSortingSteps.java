package com.rozetka.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.swing.*;
import java.util.List;

import static com.rozetka.pages.pageUtils.PagesProvider.getSearchResultsPage;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsSortingSteps {

    @When("I select the sorting {string}")
    public void iClickOnTheSorting(String sortingOption) {
        getSearchResultsPage.clickSelectSortingOrderOption(sortingOption);
    }

    @Then("I should see the searched item's list sorted in expected {string}")
    public void iShouldSeeTheSearchedItemSListSortedIn(String expectedOrderName) {
        List<Integer> actualSearchedItemsListPrice = getSearchResultsPage.getSearchedItemPriceList();
        if (expectedOrderName.equals(SortOrder.ASCENDING.toString())) {
            assertThat(actualSearchedItemsListPrice)
                    .overridingErrorMessage("The actual searched items list is not sorted in ascending order!")
                    .isSorted();
        }

        if (expectedOrderName.equals(SortOrder.DESCENDING.toString())) {
            assertThat(getSearchResultsPage.descendingSortedList(actualSearchedItemsListPrice))
                    .overridingErrorMessage
                           ("The actual searched items list is not sorted in descending order!")
                    .isEqualTo(actualSearchedItemsListPrice);
        }
    }
}
