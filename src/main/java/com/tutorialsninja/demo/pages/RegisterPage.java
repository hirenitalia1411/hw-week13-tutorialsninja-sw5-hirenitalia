package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(name = "firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(name = "lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(name = "email")
    WebElement email;

    @CacheLookup
    @FindBy(name = "telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(name = "confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(name = "newsletter")
    WebElement newsletter;

    @CacheLookup
    @FindBy(name = "agree")
    WebElement privacyPolicy;

    @CacheLookup
    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueAfterPrivacyButton;


    public void sendFirstName(String inputFirstName) {
        sendTextToElement(firstName, inputFirstName);
    }

    public void sendLastName(String inputLastName) {
        sendTextToElement(lastName, inputLastName);
    }

    public void sendEmail(String text) {
        sendTextToElement(email, text + getRandomAlphaNumericString(4) + "@gmail.com");
    }

    public void sendTelephone(String inputTelephone) {
        sendTextToElement(telephone, inputTelephone);
    }

    public void sendPassword(String inputPassword) {
        sendTextToElement(password, inputPassword);
    }

    public void sendConfirmPassword(String inputConfirmPassword) {
        sendTextToElement(confirmPassword, inputConfirmPassword);
    }

    public void clickOnSubscribeToNewsletter() {
        clickOnElement(newsletter);
    }

    public void clickOnPrivacyPolicy() {
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueAfterPrivacyButton() {
        clickOnElement(continueAfterPrivacyButton);
    }
}
