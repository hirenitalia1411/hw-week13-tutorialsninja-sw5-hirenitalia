package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsPath;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement dropDownPath;

    String sortAToZ = "Name (A - Z)";
    String sortZToA = "Name (Z - A)";
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement productHPLP3065;

    public String getDesktopText() {
        return getTextFromElement(desktopText);
    }

    public void clickOnSortByPosition() {
        clickOnElement(dropDownPath);
    }

    public void selectSortByAToZ(String text) {
        selectByVisibleTextFromDropDown(dropDownPath, text);
    }

    public void selectSortByZToA(String text) {
        selectByVisibleTextFromDropDown(dropDownPath, text);
    }

    public void clickOnHPLP3065() {
        clickOnElement(productHPLP3065);
    }

    public ArrayList<String> expectedList() {
        // Get all the products name and stored into array list
        List<WebElement> products = productsPath;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        return originalProductsName;
    }

    public ArrayList beforeSorting() {
        List<WebElement> product = productsPath;
        ArrayList<String> originalList = new ArrayList<>();
        for (WebElement list : product) {
            originalList.add(list.getText());
        }
        return originalList;
    }

    public ArrayList afterSorting() {
        Collections.reverse(beforeSorting());
        System.out.println(beforeSorting());
        List<WebElement> products = productsPath;
        ArrayList<String> afterSortingList = new ArrayList<>();
        for (WebElement newSortList : products) {
            afterSortingList.add(newSortList.getText());
        }
        return afterSortingList;
    }


}
