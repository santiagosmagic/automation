package Engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ADMControls {
	
	WebDriver driver = new FirefoxDriver();
	
	public ADMControls() {
		System.out.println("Loading ADM Field Inputs Map.");
	}
	
	public void username(String name) {
		driver.findElement(By.id("email")).sendKeys(name);
	}
	
	public void password(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
}
