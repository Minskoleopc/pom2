package utilies;

import org.openqa.selenium.WebDriver;

public class Utils {
	
	WebDriver driver;
	public Utils(WebDriver driver) {
		this.driver  = driver;
	}
	
	public boolean validateUrl(String text) {
		return this.driver.getCurrentUrl().contains(text);
	}
	

}
