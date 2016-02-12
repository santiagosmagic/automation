/**
 * KioskButtons.java
 * Written By: Tim Converse
 * 
 * This file contains functions for accessing every type of control used on a Kiosk in both Cashier Service
 * and Self Service.
 * 
 * Functions are grouped together based mostly on which screens they appear on.
 */

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KioskCS {

	//class wide variables
	//WebDriver driver = KioskFireFox.driverK;
	WebDriver driver = new FirefoxDriver();
	static int waitTime = 5;
	
	//constructor
	public KioskCS() {
		System.out.println("Loading Kiosk Button Map.");
	}
	
	//====================================================
	// Helper functions
	//====================================================
	
	// Start up a browser for the kiosk to run in.  Give it
	// three seconds to fully load.
	public void getKiosk(String kiosk) {
		driver.get(kiosk);
		String i = driver.getCurrentUrl();
		System.out.println(i);
		driver.manage().window().maximize();
		pause(1000);
	}
	
	// Close down the browser the kiosk is running in.
	public void closeKiosk() {
		driver.close();
	}
	
	// Use pause(int) as a means of providing a hard
	// time delay between steps.
	public void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Sleep Failure.");
			e.printStackTrace();
		}
	}

	//====================================================
	// Kiosk Login Screen buttons.
	// These buttons are all found on the main login page.
	//====================================================
	
	//number 0 thru 9 buttons
	public void clickLoginB1() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b1")));
		temp.click();
	}
	
	public void clickLoginB2() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b2")));
		temp.click();
	}
	
	public void clickLoginB3() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b3")));
		temp.click();
	}
	
	public void clickLoginB4() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b4")));
		temp.click();
	}
	
	public void clickLoginB5() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b5")));
		temp.click();
	}
	
	public void clickLoginB6() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b6")));
		temp.click();
	}
	
	public void clickLoginB7() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b7")));
		temp.click();
	}
	
	public void clickLoginB8() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b8")));
		temp.click();
	}
	
	public void clickLoginB9() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b9")));
		temp.click();
	}
	
	public void clickLoginB0() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("b0")));
		temp.click();
	}
	
	// login button
	public void login() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		temp.click();
	}
	
	// switch to self service
	public void selfService() {
		//note - self service button is labeled oddly
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("cancel")));
		temp.click();
	}
	
	// reboot the system
	public void reboot() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("reboot")));
		temp.click();
	}
	
	// shutdown kiosk
	public void shutDown() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("shutdown")));
		temp.click();		
	}
	
	//=================================================
	//Order Screen buttons
	// these buttons are found on the order screen
	//=================================================
	
	// main user menu button
	public void usrOptionBtn() {
		pause(2000);
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("userOptBtn")));
		temp.click();
	}

	public void signOffBtn() {
		pause(1000);
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("signoffBtn")));
		temp.click();
		pause(2000);
	}
	
	public void accessDesktop() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("desktopBtn")));
		temp.click();
	}
	
	public void fundSogo() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("fundsogoBtn")));
		temp.click();
	}
	
	public void clickManageCashDrawer() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("managePrtBtn")));
		temp.click();
	}
	
	public void clickSalesHistory() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("historyBtn")));
		temp.click();
	}
	
	public void clickLogout() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("logoutBtn")));
		temp.click();
	}
	
	public String getUserName() {
		String name = "";
		
		WebElement temp = (new WebDriverWait(driver, waitTime))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		name = temp.findElement(By.cssSelector("span")).getAttribute("innerHTML");
		
		return name;
	}
	
	//=================================================
	
	public void clearCartBtn() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("clearCartBtn")));
		temp.click();
	}
	
	public void payBtn() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("payBtn")));
		temp.click();
	}

	public void addProductToCart(String product) {
		//get array of elements
		pause(1000);
		By bySelector = By.cssSelector("button.prdbox");
		List<WebElement> elements = driver.findElements(bySelector);
		
		for (WebElement item : elements) {
			String test = item.getAttribute("innerHTML");
			if (test.contains(product)){
				item.click();
			}
		}	
	}
	
	public void selectMenuCatagory(String menuChoice) {
		//get array of elements
		By cName = By.className("btn lvl1tab");
		List<WebElement> elements = driver.findElements(cName);
		
		for (WebElement item : elements) {
			String test = item.getAttribute("innerHTML");
			if (test.contains(menuChoice)){
				item.click();
			}
		}
	}
	
	//==================================================
	//Cash Drawer
	// these functions access the cash drawer dialog
	//==================================================
	public void manageCashDrawerBtn() {
		pause(1000);
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("managePrtBtn")));
		temp.click();
		pause(1000);
	}
	
	public void closeManageCashDrawer() {
		pause(2000);
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.className("closeManage")));
		temp.click();
	}

	public void selectCashDrawer(String drawer) {
		pause(1000);
		//get array of elements
		By bySelector = By.cssSelector("li");
		List<WebElement> elements = driver.findElements(bySelector);
		
		for (WebElement item : elements) {
			String test = item.getAttribute("innerHTML");
			if (test.contains(drawer)) {
				item.click();
			}
		}
		pause(1000);
	}
	
	//=================================================
	// Payment Screen buttons
	//=================================================	
	
	public void selectPaymentMethod(String payment) {
		if (payment == "Cashless")
			driver.findElement(By.id("payBtn1")).click();
		if (payment == "Cash")
			driver.findElement(By.id("payBtn2")).click();
		if (payment == "Special")
			driver.findElement(By.id("payBtn3")).click();
	}
	
	public void paymentButton(int i) {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td[data-value='"+i+"']")));
		temp.click();
	}
	
	public void acceptTenderButton() {
		//get array of elements
		By elem = By.cssSelector("button");
		List<WebElement> elements = driver.findElements(elem);
		
		for (WebElement item : elements) {
			String test = item.getAttribute("innerHTML");
			if (test.contains("ACCEPT TENDER")) {
				item.click();
			}
		}
	}
	
	public void quickAmountButton(String qAmount) {
		//get array of elements
		By elem = By.cssSelector("button");
		List<WebElement> elements = driver.findElements(elem);
		
		for (WebElement item : elements) {
			String test = item.getAttribute("innerHTML");
			if (test.contains(qAmount)) {
				item.click();
			}
		}
	}

	//=================================================	
	// Receipt dialog buttons
	//=================================================
	public void noReceipt() {
		pause(1000);
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("salescompleteBtn")));
		temp.click();
	}
	
	public void printReceipt() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("salescompletePrintBtn")));
		temp.click();
	}
	
	public void emailReceipt() {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("salescompleteEmailBtn")));
		temp.click();
	}
	
	public void receiptButton(String receipt) {
		//get array of elements
		By elem = By.cssSelector("button");
		List<WebElement> elements = driver.findElements(elem);
		
		for (WebElement item : elements) {
			String test = item.getAttribute("innerHTML");
			if (test.contains(receipt)) {
				item.click();
			}
		}
	}
	
	//=================================================	
	// get information methods
	// use these methods to get values from labels or
	// fields on any of the screens.
	//=================================================
	
	public double getPaymentAmount() {
		double amount = 0.0;
		String content = "";
		
		WebElement temp = (new WebDriverWait(driver, waitTime))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("totalAmt")));		
		content = temp.findElement(By.xpath("span[2]")).getAttribute("innerHTML");
		amount = Double.parseDouble(content);
		return amount;
	}
	
	public double getTaxAmount() {
		double amount = 0.0;
		String content = "";
		
		WebElement temp = (new WebDriverWait(driver, waitTime))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("taxAmt")));		
		content = temp.findElement(By.xpath("span[2]")).getAttribute("innerHTML");
		amount = Double.parseDouble(content);
		return amount;
	}
	
	public double getSubTotal() {
		double amount = 0.0;
		String content = "";
		
		WebElement temp = (new WebDriverWait(driver, waitTime))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("taxAmt")));		
		content = temp.findElement(By.xpath("span[2]")).getAttribute("innerHTML");
		amount = Double.parseDouble(content);		
		return amount;
	}
	
	public double getCashAmountEntered() {
		double amount = 0.0;
		String content = "";
		
		WebElement temp = (new WebDriverWait(driver, waitTime))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("payAmt")));
		content = temp.getAttribute("value");
		amount = Double.parseDouble(content);
		return amount;
	}
	
	public void sendCashAmount(String amount) {
		WebElement temp = (new WebDriverWait(driver, waitTime))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("payAmt")));
		temp.sendKeys(amount);
	}
	
}
