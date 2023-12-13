package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkoutText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-checkout']//input[@value='guest']")
    WebElement guestCheckoutRadioButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButtonBillingDetails;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement country;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement regionOrState;

    @CacheLookup
    @FindBy(name = "comment")
    WebElement commentBox;

    @CacheLookup
    @FindBy(name = "agree")
    WebElement termsAndConditionsRadioBox;

    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement continueButtonCommentDetails;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement paymentMethodWarning;

    public String getCheckoutText() {
        return getTextFromElement(checkoutText);
    }

    public String getNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton() {
        clickOnElement(guestCheckoutRadioButton);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void clickOnContinueBillingButton() {
        clickOnElement(continueButtonBillingDetails);
    }

    public void clickOnContinueCommentButton() {
        clickOnElement(continueButtonCommentDetails);
    }

    public void enterBillingDetailsFirstName(String inputFirstName) {
        sendTextToElement(firstName, inputFirstName);
    }

    public void enterBillingDetailsLastName(String inputLastName) {
        sendTextToElement(lastName, inputLastName);
    }

    public void enterBillingDetailsEmail(String inputEmail) {
        sendTextToElement(email, inputEmail);
    }

    public void enterBillingDetailsTelephone(String inputTelephone) {
        sendTextToElement(telephone, inputTelephone);
    }

    public void enterBillingDetailsAddress(String inputAddress) {
        sendTextToElement(address, inputAddress);
    }

    public void enterBillingDetailsCity(String inputCity) {
        sendTextToElement(city, inputCity);
    }

    public void enterBillingDetailsPostcode(String inputPostcode) {
        sendTextToElement(postCode, inputPostcode);
    }

    public void enterBillingDetailsCountry(String inputCountry) {
        selectByVisibleTextFromDropDown(country, inputCountry);
    }

    public void enterBillingDetailsRegionOrState(String inputRegion) {
        selectByVisibleTextFromDropDown(regionOrState, inputRegion);
    }

    public void enterComment(String comment) {
        sendTextToElement(commentBox, comment);
    }

    public void clickOnAgreeToTermsAndConditions() {
        clickOnElement(termsAndConditionsRadioBox);
    }

    public Boolean isPaymentWarningAppearing() {
        return getTextFromElement(paymentMethodWarning).contains("Warning: Payment method required!");
    }
}
