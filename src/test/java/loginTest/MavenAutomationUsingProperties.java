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
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("URL"));
	}

	@AfterClass
	public void end() {
		driver.close();
	}

	@Test
	public void test() {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("User"));
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//i[@class='icon-lock left']")).click();
	}
}
