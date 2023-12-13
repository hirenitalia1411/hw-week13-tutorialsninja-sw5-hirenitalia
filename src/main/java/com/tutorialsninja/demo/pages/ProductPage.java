package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement productHPLP3065OnProductPage;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendarButtonLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List<WebElement> daysOfTheMonth;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[@class='datepicker-days']//th[@class='next']")
    WebElement nextButton;

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantityBox;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/a[2]")
    WebElement shoppingCart;

    public String getHPLP3065text() {
        return getTextFromElement(productHPLP3065OnProductPage);
    }

    public void selectDate(String inputDay, String inputMonth, String inputYear) {
        clickOnElement(calendarButtonLink);
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String splitMonth = arr[0];
            String splitYear = arr[1];
            if (splitMonth.equalsIgnoreCase(inputMonth) && splitYear.equalsIgnoreCase(inputYear)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = daysOfTheMonth;
        for (WebElement dateStore : allDates) {
            if (dateStore.getText().equalsIgnoreCase(inputDay)) {
                dateStore.click();
                break;
            }
        }
    }

    public void clearAndAddQuantity(String quantity) {
        quantityBox.clear();
        sendTextToElement(quantityBox, quantity);
    }

    public void clickAddToCart() {
        clickOnElement(addToCartButton);
    }

    public Boolean isSuccessMessageAppearing() {
        return getTextFromElement(successMessage).contains("Success: You have added HP LP3065 to your shopping cart!");
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }

}
