package com.rozetka.pages;

import org.openqa.selenium.Keys;

import static java.lang.String.format;

public class SignUpPage extends BasePage {

    private static final String REGISTER_LINK = "//div[@class='form__row auth-modal__form-bottom']/a[contains(., '%s')]";
    private static final String VALIDATION_SECTION = "//fieldset[contains(@class,'%s')]";
    private static final String REGISTRATION_FIELD = VALIDATION_SECTION + "/label[contains(.,'%s')]/following-sibling::input";
    private static final String WARNING_MESSAGE = VALIDATION_SECTION + "//p[text()]";

    public void clickRegistrationLink(String signUpLink) {
        clickOnButtonOrLinkByXpath(format(REGISTER_LINK, signUpLink));
    }

    public void enterUsersData(String fieldSetName, String inputLabelName, String usersData) {
        findElementByXpath(format(REGISTRATION_FIELD, fieldSetName, inputLabelName))
                .sendKeys(usersData, Keys.ENTER);

    }

    public String getActualWarningMessage(String fieldSetName) {
        return findElementByXpath(format(WARNING_MESSAGE, fieldSetName)).getText();
    }

}
