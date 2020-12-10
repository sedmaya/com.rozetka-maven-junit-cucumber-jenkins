package com.rozetka.pages;

public class Iphone12Page extends BasePage {
    private static final String ITEMS_PDP_TITLE = "//div[@class='product__heading']/h1[text()]";
    private static final String BUY_BUTTON = "//div[@class='product-trade']//button[contains(@aria-label, 'Купить')]";
    private static final String CART_POPUP_WINDOW = "//single-modal-window//h3[contains(.,'Корзина')]";

    public String getItemsPdpTitle() {
        return findElementByXpath(ITEMS_PDP_TITLE).getText();
    }

    public void clickBuyButton() {
        clickOnButtonOrLinkByXpath(BUY_BUTTON);
    }

    public Boolean isCartPopupWindowDisplayed() {
        return findElementByXpath(CART_POPUP_WINDOW).isDisplayed();
    }

}
