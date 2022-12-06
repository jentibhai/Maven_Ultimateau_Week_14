package com.ultimateqa.courses.pages;

import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility{


    By emailField =  By.id("user[email]");

    By passwordField = By.id("user[password]");

    By LoginButton =By.xpath("//button[contains(text(),'Sign in')]");

    By errorMessage = By.xpath("//li[contains(text(),'Invalid email or password.')]");

    By errorMessage1 = By.xpath("//h2[@class='page__heading']");



    public String verifyErrorMessage(){
        return getTextFromElement(errorMessage);}

    public String verifyErrorMessage1(){
        return getTextFromElement(errorMessage1);
    }

        public void clickOnLoginButton(){
        clickElement(LoginButton);
    }



    public void enterEmailId(String email){
        sendTextToelement(emailField,email);
    }
    public void enterPassword(String password){
        sendTextToelement(passwordField,password);
    }







}
