import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import Engine.KioskCSControls;
import Engine.KioskSubTasks;

public class KioskCSFireFox {

	static KioskCSControls cs = new KioskCSControls();
	static KioskSubTasks tasks = new KioskSubTasks(cs);
	static int testcount;	
	
	@BeforeClass
	public static void setup() {
		
		String kioskIP = "http://192.168.11.85:3000/";
		
		//Dennis environment
		//String kioskIP = "http://192.168.11.150:3000/";
		
		cs.getKiosk(kioskIP);
		testcount = 0;
	}
	
	@Before
	public void count() {
		testcount = testcount+1;
		System.out.println("Test Count " + testcount);
		System.out.println("");
	}
	
	@AfterClass
	public static void done() {
		cs.closeKiosk();
	}
	
	@After
	public void showcount() {
		System.out.println("End Test: " + testcount);
		System.out.println("=============================================");
		System.out.println("");
	}

	//Tests
	
	@Test
	public void cashierLogIn() {
	//Test a simple transaction logging in as a cashier
		System.out.println("Cashier Log In and Simple Transaction.");
		try {
			cs.clickLoginB1();
			cs.clickLoginB1();
			cs.clickLoginB1();
			cs.clickLoginB1();
			cs.login();
			
			cs.selectCashDrawer("SelfServiceNoCashDrawer");
			cs.addProductToCart("Apple");
			cs.addProductToCart("Banana");
			
			System.out.println("Before Pay button: "+cs.getPaymentAmount());
			
			cs.payBtn();
			
			System.out.println("Payment Amount: "+cs.getPaymentAmount());
			
			cs.selectPaymentMethod("Cash");
			cs.quickAmountButton("EXACT CHANGE");
			cs.acceptTenderButton();
			cs.noReceipt();
			cs.usrOptionBtn();	
			
			cs.signOffBtn();
			
			System.out.println("Passed.");
			
		} catch (Exception e) {
			System.out.println("Test Failed" + e);
			fail("Test Failed.");
		}
	}
	
	@Test
	public void managerLogIn() {
	//Test a simple transaction loggin in as a manager
		System.out.println("Manager Log In and Simple Transaction.");
		try {
			
			cs.clickLoginB9();
			cs.clickLoginB9();
			cs.clickLoginB9();
			cs.clickLoginB9();
			cs.login();
			
			cs.selectCashDrawer("SelfServiceNoCashDrawer");
			cs.addProductToCart("Apple");
			cs.addProductToCart("Banana");
			cs.payBtn();
			
			//System.out.println("Payment Amount: "+buttons.getPaymentAmount());
			
			cs.selectPaymentMethod("Cash");
			cs.quickAmountButton("EXACT CHANGE");
			cs.acceptTenderButton();
			cs.noReceipt();
			cs.usrOptionBtn();	
			
			cs.signOffBtn();
		
			System.out.println("Passed.");
			
		} catch (Exception e) {
			System.out.println("Test Failed" + e);
			fail("Test Failed.");
		}
	}
	
	@Test
	public void getUserName() {
		System.out.println("Manager Log In and Verify Manager.");
		try {
			
			tasks.login("Manager");
			
			cs.selectCashDrawer("SelfServiceNoCashDrawer");
			cs.usrOptionBtn();			
			System.out.println("User is: "+cs.getUserName());
			
			tasks.resetKiosk("SelfServiceNoCashDrawer");
			
			cs.signOffBtn();	
			System.out.println("Passed.");
			
		} catch (Exception e) {
			System.out.println("Test Failed" + e);
			fail("Test Failed.");
		}
	}
	
	@Test
	public void testFailure() {
		System.out.println("Delibereate Fail.");
		fail("Automatic failure.");
	}

	@Test
	public void testNewLoginAndLogout() {
		System.out.println("Test New Login and Logout");
		if (tasks.login("Cashier"))
			System.out.println("Logged in as Cashier.");
		else
			fail("Failed to login as Cashier.");
		
		cs.selectCashDrawer("SelfServiceNoCashDrawer");
		
		if (tasks.logout())
			System.out.println("Logout succeeded.");
		else
			fail("Logout failed.");
	}
	
	@Ignore
	@Test
	public void loginToMicroMart() {
		cs.getKiosk("http://192.168.106.101:3000/mm/");
	}
}
