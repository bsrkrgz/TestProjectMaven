package com.uss.test.TestProjectMaven;

/**
 * BUSRA KARAGOZ
 */
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.facebook.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testProjectDeneme() throws Exception {
    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("testproject974@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("bus1234bus");
    driver.findElement(By.id("u_0_l")).click();
    driver.get("http://www.n11.com/");
    assertEquals("n11.com - Alışverişin Uğurlu Adresi", driver.getTitle());
    driver.findElement(By.linkText("Giriş Yap")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("busrakaragoz0@gmail.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("bus1234bus");
    driver.findElement(By.id("loginButton")).click();
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*busra karagöz[\\s\\S]*$"));
    driver.findElement(By.id("searchData")).click();
    driver.findElement(By.id("searchData")).clear();
    driver.findElement(By.id("searchData")).sendKeys("samsung");
    driver.findElement(By.cssSelector("a.searchBtn")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*sonuç bulundu[\\s\\S]*$"));
    driver.findElement(By.linkText("2")).click();
    assertEquals("2", driver.findElement(By.name("currentPage")).getAttribute("value"));
    driver.findElement(By.cssSelector("#p-38711636 > div.pro > a.plink > img.lazy")).click();
    
    driver.findElement(By.id("addToFavourites")).click();
    assertEquals("", driver.findElement(By.id("addToFavourites")).getText());
    driver.findElement(By.linkText("Favorilerim")).click();
    driver.findElement(By.name("itemSelected")).click();
    driver.findElement(By.id("removeSelectedProducts")).click();
    
    /*driver.findElement(By.linkText("Sepete Ekle")).click();
    driver.findElement(By.cssSelector("a.myBasket")).click();
    driver.findElement(By.linkText("Sil")).click();
    assertThat("Samsung ", is(not(driver.findElement(By.cssSelector("h4")).getText())));*/
    driver.get("http://www.n11.com/");
    
    
    
   
    
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
