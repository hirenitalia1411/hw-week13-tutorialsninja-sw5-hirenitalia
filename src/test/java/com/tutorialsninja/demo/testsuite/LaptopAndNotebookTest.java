package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaptopAndNotebookTest extends BaseTest {

    HomePage homePage;
    LaptopAndNoteBookPage laptopAndNoteBookPage;
    MacBookPage macBookPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        laptopAndNoteBookPage = new LaptopAndNoteBookPage();
        macBookPage = new MacBookPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckOutPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        homePage.mouseHoverAndClickOnLaptopsAndNotebooks();
        homePage.selectMenu("Laptops & Notebooks");
        laptopAndNoteBookPage.selectPriceHighToLow("Price (High > Low)");
        Assert.assertEquals(laptopAndNoteBookPage.afterSorting(), laptopAndNoteBookPage.beforeSorting(), "products not sorted by Price High to Low");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {
        homePage.selectMenu("Laptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopAndNoteBookPage.selectPriceHighToLow("Price (High > Low)");
        //2.4 Select Product “MacBook”
        laptopAndNoteBookPage.clickOnMacbook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(macBookPage.getTextFromMacBook(), "MacBook", "MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(macBookPage.isSuccessMessageAppearing(), "Message Doesn't Appear");
        //2.8 Click on link “shopping cart” display into success message
        macBookPage.clickOnShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getProductName(), "MacBook", "Product Name Doesn't appear");
        //2.11 Change Quantity "2"
        shoppingCartPage.clearAndAddQuantity("2");
        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdate();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(shoppingCartPage.isSuccessMessageAppearing("Success: You have modified your shopping cart!"), "Cart not modified");
        //2.14 Verify the Total $1,204.00
        Assert.assertEquals(shoppingCartPage.getTotalText(), "$1,204.00", "Total not matched");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckout();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(checkoutPage.getCheckoutText(), "Checkout", "Checkout not displayed");
        //2.17 Verify the Text “New Customer”
        Assert.assertEquals(checkoutPage.getNewCustomerText(), "New Customer", "New Customer not displayed");
        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestCheckoutRadioButton();
        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        checkoutPage.enterBillingDetailsFirstName("Meet");
        checkoutPage.enterBillingDetailsLastName("patel");
        checkoutPage.enterBillingDetailsEmail("Patel" + getRandomAlphaNumericString(4) + "@gmail.com");
        checkoutPage.enterBillingDetailsTelephone("07654321234");
        checkoutPage.enterBillingDetailsAddress("11 harrow Road");
        checkoutPage.enterBillingDetailsCity("Harrow");
        checkoutPage.enterBillingDetailsPostcode("HA91Sf");
        checkoutPage.enterBillingDetailsCountry("United Kingdom");
        checkoutPage.enterBillingDetailsRegionOrState("Aberdeen");
        //2.21 Click on “Continue” Button
        checkoutPage.clickOnContinueBillingButton();
        //2.22 Add Comments About your order into text area
        checkoutPage.enterComment("Nothing Specific.");
        //2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnAgreeToTermsAndConditions();
        //2.24 Click on “Continue” button
        checkoutPage.clickOnContinueCommentButton();
        //2.25 Verify the message “Warning: Payment method required!”
        Assert.assertTrue(checkoutPage.isPaymentWarningAppearing(), "Payment Warning not displayed");
    }
}
