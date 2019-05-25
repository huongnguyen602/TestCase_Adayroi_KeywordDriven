package Demo.TestCase_Adayroi_KeywordDriven.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Demo.TestCase_Adayroi_KeywordDriven.executionEngine.DriverScript.OR;

public class ActionKeywords {
	public static WebDriver driver;
	static WebDriverWait wait;

	public static void openBrowser(String object) {
		System.setProperty("webdriver.chrome.driver", Constants.Path_Driver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void navigate(String object) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		wait = new WebDriverWait(driver, 10);

	}

	public static void hover_MyAccount(String object) {
		Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.xpath("//*[@class = 'header-username']"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath(OR.getProperty(object)))).build().perform();
	}

	public static void click_SignIn(String object) {
		 //driver.findElement(By.xpath("//div[@class ='row']/div[2]/button/div")).click();
		// This is fetching the xpath of the element from the Object Repository property file
		driver.findElement(By.xpath(OR.getProperty(object))).click();
	}

	public static void input_Username(String object) throws InterruptedException {
		//driver.findElement(By.id("j_username")).sendKeys("0981284843");
		driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.UserName); 
	}

	public static void input_Password(String object) {
		//driver.findElement(By.id("j_password")).sendKeys("123456?a");
		 driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.Password);
	}

	public static void click_SignInConfirmation(String object) {
		//driver.findElement(By.xpath("//*[@class='btn btn-primary btn-block js-login-btn']")).click();
		driver.findElement(By.xpath(OR.getProperty(object))).click();
	}

	public static void closeBrowser(String object) {
		// driver.quit();
	}

}
