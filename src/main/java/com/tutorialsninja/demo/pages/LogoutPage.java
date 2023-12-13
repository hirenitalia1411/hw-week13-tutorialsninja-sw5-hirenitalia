package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends Utility {

        @CacheLookup
        @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
        WebElement logoutText;

        public String getTextFromLogout() {
            return getTextFromElement(logoutText);
        }
}
