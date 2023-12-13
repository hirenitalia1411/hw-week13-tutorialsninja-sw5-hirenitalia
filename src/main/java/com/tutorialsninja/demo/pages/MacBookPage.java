package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/a[2]")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    public String getTextFromMacBook() {
        return getTextFromElement(macBookText);
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    public Boolean isSuccessMessageAppearing() {
        return getTextFromElement(successMessage).contains("Success: You have added MacBook to your shopping cart!");
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }
}
