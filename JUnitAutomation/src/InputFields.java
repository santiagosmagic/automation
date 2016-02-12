import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputFields {
	
	WebDriver driver = ADMFireFox.driverADM;
	
	public InputFields() {
		System.out.println("Loading ADM Field Inputs Map.");
	}
	
	public void username(String name) {
		driver.findElement(By.id("email")).sendKeys(name);
	}
	
	public void password(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
}
