package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement continueAfterLogout;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h2[text()='My Account']")
    WebElement myAccountText;


    public void selectMyAccountOption(String option) {
        List<WebElement> myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountsList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
    }

    public void clickOnContinueAfterLogout() {
        clickOnElement(continueAfterLogout);
    }

    public String getMyAccountText() {
        return getTextFromElement(myAccountText);
    }
}
