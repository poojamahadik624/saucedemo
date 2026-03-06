package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.testng.Assert;

public class LoginTest extends BaseTest {

	@Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
	
	@Test
	public void invalidLoginTest() {

	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login("wrong_user", "wrong_pass");

	    Assert.assertTrue(driver.getPageSource().contains("Epic sadface"));
	}
}
