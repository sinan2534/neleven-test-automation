package com.finartz.neleven.page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  protected WebDriver webDriver;
  protected WebDriverWait webDriverWait;

  public BasePage(WebDriver webDriver) {
    this.webDriver = webDriver;
    webDriverWait = new WebDriverWait(webDriver, 30, 150);
  }

  protected WebElement find(By by) {
    return webDriver.findElement(by);
  }

  protected WebElement findByClickable(By by) {
    return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
  }

  protected WebElement findByVisible(By by) {
    return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  protected List<WebElement> finds(By by) {
    return webDriver.findElements(by);
  }

  protected List<WebElement> findsByPresence(By by) {
    return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
  }

  protected void click(WebElement element) {
    element.click();
  }

  protected String getText(WebElement element) {
    return element.getText();
  }

  protected void sendKeys(WebElement element, String text) {
    element.sendKeys(text);
  }

  protected void scrollToElement(WebElement element) {
    new Actions(webDriver).moveToElement(element).build().perform();
  }

  protected String getPageUrl() {
    return webDriver.getCurrentUrl();
  }

  protected void waitPageLoadComplete() {
    try {
      webDriverWait.until(
          driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
              .toString()
              .equals("complete"));
    } catch (Throwable error) {
      error.printStackTrace();
    }
  }


  protected void waitJQueryComplete() {
    Boolean existJquery = (Boolean) ((JavascriptExecutor) webDriver)
        .executeScript("return (typeof(jQuery) != 'undefined')");
    if (existJquery) {
      try {
        webDriverWait.until(driver -> (Boolean) ((JavascriptExecutor) driver)
            .executeScript("return jQuery.active == 0"));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  protected void waitAll() {
    waitPageLoadComplete();
    waitJQueryComplete();
  }


}
