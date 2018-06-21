package com.finartz.neleven.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class NavBar<T> extends BasePage {

  public NavBar(WebDriver webDriver) {
    super(webDriver);
  }

  public LoginPage openLoginPage() {
    click(findByClickable(By.cssSelector(".btnSignIn")));
    return new LoginPage(webDriver);
  }

  public T checkUsernameIsVisible() {
    Assert.assertFalse(findByVisible(By.cssSelector(".menuLink.user")).getText().isEmpty());
    return getT();
  }

  public SearchPage searchProduct(String productName) {
    sendKeys(findByVisible(By.id("searchData")), productName);
    click(findByClickable(By.cssSelector(".searchBtn")));
    return new SearchPage(webDriver);
  }

  public AccountPage openAccountPage() {
    click(findByClickable(By.cssSelector(".myAccount>.menuTitle")));
    Assert.assertTrue(getText(findByVisible(By.cssSelector("#breadCrumb>ul>li:nth-of-type(2)")))
        .contains("Hesabım"));
    return new AccountPage(webDriver);
  }

  public LoginPage logout() {
    scrollToElement(findByVisible(By.cssSelector(".myAccount>.menuTitle ")));
    click(findByClickable(By.cssSelector(".logoutBtn")));
    Assert.assertNotNull(find(By.id("email")));
    return new LoginPage(webDriver);
  }

  protected abstract T getT();
}
