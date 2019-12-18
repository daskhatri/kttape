

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FulAutoTest2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFulAutoTest2() throws Exception {
    driver.get("https://katalon-demo-cura.herokuapp.com/");
    driver.findElement(By.id("btn-make-appointment")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Demo account'])[1]/following::input[1]")).click();
    driver.findElement(By.id("txt-username")).click();
    driver.findElement(By.id("txt-username")).clear();
    driver.findElement(By.id("txt-username")).sendKeys("John Doe");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Demo account'])[1]/following::div[5]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Demo account'])[1]/following::input[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Demo account'])[1]/following::input[2]")).click();
    driver.findElement(By.id("txt-password")).click();
    driver.findElement(By.id("txt-password")).clear();
    driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
    driver.findElement(By.id("btn-login")).click();
    driver.findElement(By.id("txt_comment")).click();
    driver.findElement(By.id("txt_comment")).clear();
    driver.findElement(By.id("txt_comment")).sendKeys("That is all for this test now lets try some more clicks");
    driver.findElement(By.id("combo_facility")).click();
    new Select(driver.findElement(By.id("combo_facility"))).selectByVisibleText("Hongkong CURA Healthcare Center");
    driver.findElement(By.id("combo_facility")).click();
    driver.findElement(By.id("radio_program_medicaid")).click();
    driver.findElement(By.id("txt_visit_date")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[1]/following::td[24]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[1]/following::td[35]")).click();
    driver.findElement(By.id("txt_visit_date")).click();
    driver.findElement(By.id("btn-book-appointment")).click();
    driver.close();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Java Guides'])[4]/following::div[5]")).click();
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
