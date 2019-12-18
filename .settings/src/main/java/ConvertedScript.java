import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ConvertedScript {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
//		System.setProperty("webdriver.chrome.driver", "Dependencies/chromedriver.exe");
//      System.setProperty("webdriver.gecko.driver", "Dependencies/geckodriver.exe");

		System.setProperty("webdriver.chrome.driver", "E:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.katalon.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testFillRegistrationForm() throws Exception {
		driver.get("https://form.jotform.me/93193093658467");
		driver.findElement(By.id("first_4")).click();
		driver.findElement(By.id("first_4")).clear();
		driver.findElement(By.id("first_4")).sendKeys("Anas");
		driver.findElement(By.id("middle_4")).clear();
		driver.findElement(By.id("middle_4")).sendKeys("khan");
		driver.findElement(By.id("input_24_month")).click();
		new Select(driver.findElement(By.id("input_24_month"))).selectByVisibleText("June");
		driver.findElement(By.id("input_24_month")).click();
		driver.findElement(By.id("input_24_day")).click();
		new Select(driver.findElement(By.id("input_24_day"))).selectByVisibleText("10");
		driver.findElement(By.id("input_24_day")).click();
		driver.findElement(By.id("input_24_year")).click();
		new Select(driver.findElement(By.id("input_24_year"))).selectByVisibleText("2009");
		driver.findElement(By.id("input_24_year")).click();
		driver.findElement(By.id("input_3")).click();
		new Select(driver.findElement(By.id("input_3"))).selectByVisibleText("Male");
		WebElement Element = driver.findElement(By.id("input_20"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(By.id("input_20")).click();
		// driver.findElement(By.xpath("(.//*[normalize-space(text()) and
		// normalize-space(.)='Submit Form'])[1]/following::div[2]")).click();
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
