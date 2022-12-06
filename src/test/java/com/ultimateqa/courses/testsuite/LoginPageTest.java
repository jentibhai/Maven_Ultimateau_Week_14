package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.LoginPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    HomePage homepage = new HomePage();


    LoginPage loginpage = new LoginPage();

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        homepage.clickOnsignLink();
        String expectedText = "Welcome Back!";
        String actualText = loginpage.verifyErrorMessage1();
        Assert.assertEquals(actualText,expectedText,"Welcome Back!");

    }

    @Test

    public void verifyTheErrorMessage(){

        homepage.clickOnsignLink();
        loginpage.enterEmailId("paijanehal@gmail.com");
        loginpage.enterPassword("nehal123");
        loginpage.clickOnLoginButton();

        String expectedText = "Invalid email or password.";
        String actualText = loginpage.verifyErrorMessage();
        Assert.assertEquals(actualText,expectedText,"Invalid email or password.");



    }


}
