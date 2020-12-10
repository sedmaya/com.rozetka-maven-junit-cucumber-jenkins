package com.rozetka.pages;

import com.rozetka.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    private final long timeout = 30;

    protected BasePage() {
        PageFactory.initElements(getDriver(), this);
        getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    protected static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    protected static WebElement findElementByXpath(String xPath) {
        return getDriver().findElement(By.xpath(xPath));
    }

    protected static List<WebElement> findElementsByXpath(String xPath) {
        return getDriver().findElements(By.xpath(xPath));
    }

    protected void clickOnButtonOrLinkByXpath(String locator) {
        new WebDriverWait(getDriver(), timeout)
                .until(ExpectedConditions.elementToBeClickable(findElementByXpath(locator))).click();
    }

    public List<Integer> descendingSortedList(List<Integer> listToCheck) {
        List<Integer> newList = new ArrayList<>(listToCheck);
        Collections.sort(newList);
        Collections.reverse(newList);
        return newList;
    }

}
