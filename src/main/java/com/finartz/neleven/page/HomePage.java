package com.finartz.neleven.page;

import org.openqa.selenium.WebDriver;

public class HomePage extends NavBar<HomePage> {

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  protected HomePage getT() {
    return this;
  }


}
