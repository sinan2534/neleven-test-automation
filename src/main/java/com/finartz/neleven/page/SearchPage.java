package com.finartz.neleven.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends NavBar<SearchPage> {

  public SearchPage(WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  protected SearchPage getT() {
    return this;
  }

  public SearchPage checkSearchProductName(String productName) {
    Assert.assertTrue(
        productName.equalsIgnoreCase(getText(findByVisible(By.cssSelector(".resultText>h1")))));
    return this;
  }

  public SearchPage openPage(int pageIndex) {
    WebElement element = findsByPresence(By.cssSelector(".pagination>a")).get(pageIndex);
    scrollToElement(element);
    element.click();
    Assert.assertTrue("Acilan sayfa indeksi yanlis",
        getPageUrl().endsWith(String.format("pg=%d", pageIndex + 1)));
    return this;
  }

  public SearchPage addToFavorite(int productIndex) {
    WebElement element = findsByPresence(By.cssSelector(".textImg.followBtn")).get(productIndex);
    scrollToElement(element);
    element.click();
    return this;
  }

  public String getProductNameByIndex(int productIndex) {
    return getText(findsByPresence(By.cssSelector(".productName")).get(productIndex));
  }
}
