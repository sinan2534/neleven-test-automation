package com.finartz.neleven.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends NavBar<LoginPage> {

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  protected LoginPage getT() {
    return this;
  }

  public HomePage login(String username, String password) {
    sendKeys(findByVisible(By.id("email")), username);
    sendKeys(findByVisible(By.id("password")), password);
    click(findByClickable(By.id("loginButton")));
    checkUsernameIsVisible();
    return new HomePage(webDriver);
  }
}
