package com.finartz.neleven.page;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends NavBar<AccountPage> {

  public AccountPage(WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  protected AccountPage getT() {
    return this;
  }

  public AccountPage openWishList() {
    click(findByClickable(By.cssSelector(".accNav>ul>li:nth-of-type(6)>a")));
    return this;
  }

  public AccountPage openMyFavorites() {
    click(findByVisible(By.cssSelector(".listItemTitle")));
    Assert
        .assertEquals("Favorilerim",
            getText(findByVisible(By.cssSelector(".group.listingGroup.wishListGroup>h2")))
        );
    return this;
  }

  public AccountPage deleteFavoriteByName(String productName) {
    List<WebElement> webElements = finds(By.cssSelector("#view>ul>li>div>div>.plink"));
    for (int i = 0; i < webElements.size(); i++) {
      if (webElements.get(i).getAttribute("title").equals(productName)) {
        click(finds(By.cssSelector(".deleteProFromFavorites")).get(i));
        click(findByClickable(By.cssSelector(".btn.btnBlack.confirm")));
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        break;
      }
    }


    return this;
  }

  public AccountPage checkFavoriteByName(String productName) {
    List<WebElement> webElements = finds(By.cssSelector("#view>ul>li>div>div>.plink"));
    boolean found;
    for (int i = 0; i < webElements.size(); i++) {
      if (webElements.get(i).getAttribute("title").equals(productName)) {
        Assert.assertTrue("Favori urun silinmemis", false);
      }
      break;
    }
    return this;
  }


}
