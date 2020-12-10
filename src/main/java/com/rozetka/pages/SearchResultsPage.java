package com.rozetka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class SearchResultsPage extends BasePage {

    private static final String SEARCHED_ITEMS_PAGE = "//div[contains(text(), 'Есть')]";
    private static final String SEARCHED_AVAILABLE_ITEMS_LIST_TEXT = SEARCHED_ITEMS_PAGE + "/ancestor::div[@class='goods-tile']//a[@title]";
    private static final String SEARCHED_AVAILABLE_ITEMS_PRICE_LIST = SEARCHED_ITEMS_PAGE + "/preceding-sibling::div[contains(@class, 'price')]//span[contains(@class, 'value')]";
    private static final String FIRST_SEARCHED_ITEM = "(" + SEARCHED_AVAILABLE_ITEMS_LIST_TEXT + ")[1]";
    private static final String SORTING_ORDER_BUTTON = "//search-sort/select";
    private static final String NO_SEARCH_RESULTS_MESSAGE = "//div[@class='search-nothing__wrap']/p[2]";

    public void clickFirstSearchedItem() {
        clickOnButtonOrLinkByXpath(FIRST_SEARCHED_ITEM);
    }

    public List<WebElement> getSearchedItemList() {
        return findElementsByXpath(SEARCHED_AVAILABLE_ITEMS_LIST_TEXT);
    }

    public List<Integer> getSearchedItemPriceList() {
        List<Integer> list = new ArrayList<>();
        for (WebElement element : findElementsByXpath(SEARCHED_AVAILABLE_ITEMS_PRICE_LIST)) {
            int number = Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));
            list.add(number);
        }
        return list;
    }


    public void clickSelectSortingOrderOption(String sortingOrder) {
        Select s = new Select(findElementByXpath(format(SORTING_ORDER_BUTTON, sortingOrder)));
        s.selectByVisibleText(sortingOrder);
    }

    public String noSearchResultsMessage() {
        return findElementByXpath(NO_SEARCH_RESULTS_MESSAGE).getText();
    }

}
