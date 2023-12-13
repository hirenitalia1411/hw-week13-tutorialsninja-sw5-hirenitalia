package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenuListField;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopTab;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNoteBooksTab;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccounts;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement loginAccountText;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Currency']")
    WebElement currencySelector;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement currencyGBP;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement showAllDesktops;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllLaptops & Notebooks']")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllComponents']")
    WebElement showAllComponents;


    public void chooseGBP() {
        clickOnElement(currencySelector);
        clickOnElement(currencyGBP);
    }

    public void selectMenu(String menu) {
        if (menu == "Desktops") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            mouseHoverToElement(desktopTab);
            clickOnElement(showAllDesktops);

        } else if (menu == "Laptops & Notebooks") {
            //Find Laptops & Notebooks tab, hover and click on "Show All Laptops & Notebooks"
            mouseHoverToElement(laptopsAndNoteBooksTab);
            clickOnElement(showAllLaptopsAndNotebooks);

        } else if (menu == "Components") {
            //Find Components tab, hover and click on "Show All Components"
            mouseHoverToElement(componentsTab);
            clickOnElement(showAllComponents);
        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }

    public void mouseHoverAndClickOnDesktop() {
        mouseHoverToElementAndClick(desktopTab);
    }

    public void mouseHoverAndClickOnLaptopsAndNotebooks() {
        mouseHoverToElementAndClick(laptopsAndNoteBooksTab);
    }

    public void mouseHoverAndClickOnComponents() {
        mouseHoverToElementAndClick(componentsTab);
    }

    public void selectMyAccountOptions(String option) {
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

    public void clickOnMyAccount() {
        clickOnElement(myAccounts);
    }

    public String getRegisterAccountText() {
        return getTextFromElement(registerAccountText);
    }

    public String getLoginAccountText() {
        return getTextFromElement(loginAccountText);
    }
}
