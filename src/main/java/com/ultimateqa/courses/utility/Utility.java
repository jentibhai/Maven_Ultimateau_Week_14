package com.ultimateqa.courses.utility;

import com.ultimateqa.courses.browserfactory.ManageBrowser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Utility extends ManageBrowser {

    /**
     * this method will click on element
     */
    public void clickElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
    /**
     * This method will send text on element
     */
    public void sendTextToelement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //************************ Alert methods*************************
    //This method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();

    }

    // Homework 4 Method - acceptAlert, dismissAlert, String getTextFromAlert, sendTextToAlert(String text)
// This method will accept alert

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    // this method will dismiss alert

    public void dismissalert() {

        driver.switchTo().alert().dismiss();
    }
// This method will get text from alert

    public String getTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
// This method will send text to alert

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys("Nehal");

    }

    //**************************Select class Methods********************

    /**
     * this Method will select option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);

    }

//    this method will select the option by value

    public void selectValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }
 /*
 public void selectByValueFromDropDown(By by, String value){
 new Select(driver.findElement(by)).selectByValue(value);

  */

    //this method will select the option by index
    public void selectDropDownIndex(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
        /*
        public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
         */

//this method will select the option by contain text

    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }


//*********************************Action Class***************************

    //mouseHoverToElement(By by),

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement a = driver.findElement(by);
        actions.moveToElement(a).build().perform();
    }
/*
public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
 */

    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions hover = new Actions(driver);
        WebElement a = driver.findElement(by);
        hover.moveToElement(a).click().build().perform();
    }
/*
This method will use to hover mouse on element and click
public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }



 */

//********************************** window Handle ************************

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

//************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;

    }



}
