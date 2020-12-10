package com.rozetka.pages;

import org.openqa.selenium.Keys;

import static java.lang.String.format;

public class HomePage extends BasePage {
    private static final String ROZETKA_URL = "https://rozetka.com.ua/";
    private static final String SEARCH_BAR = "//input[@name='search']";
    private static final String TOP_LINE_MENU_XPATH = "//div[@class='header-topline']";
    private static final String SEARCH_BAR_PLACEHOLDER_TEXT = "//input[@name='search' and contains(@placeholder, '%s')]";
    private static final String LANGUAGE_LINK = TOP_LINE_MENU_XPATH + "//li[contains(.,'%s')]";
    private static final String PERSONAL_ACCOUNT_PAGE = TOP_LINE_MENU_XPATH
            + "//button[contains(.,'%s')]";

    public void openRozetkaHomePage() {
        getDriver().get(ROZETKA_URL);
    }

    public void enterSearchKeywords(String keywords) {
        findElementByXpath(SEARCH_BAR).sendKeys(keywords, Keys.ENTER);
    }

    public void clickLanguageLink(String langName) {
        clickOnButtonOrLinkByXpath(format(LANGUAGE_LINK, langName));
    }

    public String currentURL() {
        return getDriver().getCurrentUrl();
    }

    public Boolean isSearchBarPlaceholderTextDisplayed(String placeholderText) {
        return findElementByXpath(format(SEARCH_BAR_PLACEHOLDER_TEXT, placeholderText)).isDisplayed();
    }

    public void clickPersonalAccount(String linkText) {
        clickOnButtonOrLinkByXpath(format(PERSONAL_ACCOUNT_PAGE, linkText));
    }

}
