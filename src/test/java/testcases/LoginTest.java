package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Login;
import utilies.Utils;

public class LoginTest {

	WebDriver driver;
	Login loginA ;
	Utils utilies ;
	
	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users//Lenovo//Desktop//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		loginA = new Login(driver);
		utilies = new Utils(driver);
	}

	@Test
	public void VerifyLoginWithValidCredentials() {
		loginA.login("standard_user","secret_sauce");
		boolean avail = utilies.validateUrl("inventory");
		Assert.assertTrue(avail);
	}

	@Test
	public void VerifyLoginWithinValidCredentials() {
		loginA.login("stanser","seet_sauce");
		boolean avail = loginA.errorState();
		Assert.assertTrue(avail);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
