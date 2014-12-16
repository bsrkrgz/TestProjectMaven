package com.uss.test.TestProjectMaven;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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
    driver.findElement(By.id("searchData")).click();
    driver.findElement(By.id("searchData")).clear();
    driver.findElement(By.id("searchData")).sendKeys("samsung");
    driver.findElement(By.cssSelector("a.searchBtn")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*sonuç bulundu[\\s\\S]*$"));
    driver.findElement(By.linkText("2")).click();
    assertEquals("2", driver.findElement(By.name("currentPage")).getAttribute("value"));
    driver.findElement(By.cssSelector("#p-37013121 > div.pro > a.plink > img.lazy")).click();
    driver.findElement(By.linkText("Sepete Ekle")).click();
    driver.findElement(By.cssSelector("a.myBasket")).click();
    driver.findElement(By.linkText("Sil")).click();
    assertThat("Samsung ", is(not(driver.findElement(By.cssSelector("h4")).getText())));
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
