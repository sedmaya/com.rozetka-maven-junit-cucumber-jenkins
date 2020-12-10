package com.rozetka.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.rozetka.pages.pageUtils.PagesProvider.getIphone12Page;
import static org.assertj.core.api.Assertions.assertThat;

public class CartSteps {

    @And("I click on the Buy button")
    public void iClickOnTheButton() {
        getIphone12Page.clickBuyButton();
    }

    @Then("I should see the cart's pop up window")
    public void iShouldSeeTheCartSPopUpWindow() {
        assertThat(getIphone12Page.isCartPopupWindowDisplayed())
                .overridingErrorMessage("The Cart's PopUp is not displayed.")
                .isTrue();
    }
}
