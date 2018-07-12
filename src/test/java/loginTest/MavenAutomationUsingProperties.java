package loginTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenAutomationUsingProperties {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(ConfigLoader2.getMyValue("URL"));
	}

	@AfterClass
	public void end() {
		driver.close();
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ConfigLoader2.getMyValue("User"));
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(ConfigLoader2.getMyValue("Password"));
		driver.findElement(By.xpath("//i[@class='icon-lock left']")).click();
	}
}
