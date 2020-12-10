package com.rozetka.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.rozetka.pages.pageUtils.PagesProvider.getHomePage;

public class CommonSearchSteps {

    @Given("I navigate to the rozetka.com.ua URL")
    public void openRozetkaWebSite() {
        getHomePage.openRozetkaHomePage();
    }

    @And("I enter the following keywords into a search bar")
    public void enterSearchKeywords(String searchKeywords) {
        getHomePage.enterSearchKeywords(searchKeywords);
    }

    @And("I enter the {string} into a search bar")
    public void enterKeywordIntoSearchBar(String searchKeywords) {
        getHomePage.enterSearchKeywords(searchKeywords);
    }
}
