package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DesktopTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        //choose desktop dropdown
        homePage.mouseHoverAndClickOnDesktop();
        //show all desktops
        homePage.selectMenu("Desktops");
        desktopPage.clickOnSortByPosition();
        desktopPage.selectSortByZToA("Name (Z - A)");
        Assert.assertEquals(desktopPage.afterSorting(), desktopPage.beforeSorting(), "Product not sorted into Z to A order");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.chooseGBP();//homePage.mouseHoverAndClickOnDesktop();
        homePage.selectMenu("Desktops");//desktopPage.clickOnSortByPosition();
        desktopPage.selectSortByAToZ("Name (A - Z)");

        desktopPage.clickOnHPLP3065();
        productPage.clearAndAddQuantity("1");
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.isSuccessMessageAppearing(), "Message Doesn't Appear");
        productPage.clickOnShoppingCart();
        Assert.assertTrue(shoppingCartPage.isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");
        Assert.assertEquals(shoppingCartPage.getProductName(), "HP LP3065", "Product Name Doesn't appear");
        Assert.assertEquals(shoppingCartPage.getModelText(), "Product 21", "Model Name Doesn't appear");
        Assert.assertEquals(shoppingCartPage.getTotalText(), "£74.73", "Total Doesn't appear");
    }
}
