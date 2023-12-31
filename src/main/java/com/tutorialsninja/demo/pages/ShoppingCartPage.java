package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productNameText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDateText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement modelText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']/input[@type='text']")
    WebElement quantityBox;

    @CacheLookup
    @FindBy(xpath = "//i[@class = 'fa fa-refresh']")
    WebElement refreshButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successMessageRefresh;

    @CacheLookup
    @FindBy(css = "a.btn.btn-primary")
    WebElement checkoutButton;


    public Boolean isShoppingCartAppearing() {
        return getTextFromElement(shoppingCartText).contains("Shopping Cart");
    }

    public String getProductName() {
        return getTextFromElement(productNameText);
    }

    public Boolean isDeliveryDateAppearing(String date) {
        return getTextFromElement(deliveryDateText).contains(date);
    }

    public String getModelText() {
        return getTextFromElement(modelText);
    }

    public String getTotalText() {
        return getTextFromElement(totalText);
    }

    public void clearAndAddQuantity(String quantity) {
        quantityBox.clear();
        sendTextToElement(quantityBox, quantity);
    }

    public void clickOnUpdate() {
        clickOnElement(refreshButton);
    }

    public Boolean isSuccessMessageAppearing(String message) {
        return getTextFromElement(successMessageRefresh).contains("Success: You have modified your shopping cart!");
    }

    public void clickOnCheckout() {
        clickOnElement(checkoutButton);
    }
}
