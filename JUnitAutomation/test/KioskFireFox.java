import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class KioskFireFox {

	static KioskButtons buttons = new KioskButtons();
	static int testcount;	
	
	@BeforeClass
	public static void setup() {
		
		String kioskIP = "http://192.168.11.85:3000/";
		
		//Dennis environment
		//String kioskIP = "http://192.168.11.150:3000/";
		
		buttons.getKiosk(kioskIP);
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
		buttons.closeKiosk();
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
			buttons.clickLoginB1();
			buttons.clickLoginB1();
			buttons.clickLoginB1();
			buttons.clickLoginB1();
			buttons.login();
			
			buttons.selectCashDrawer("SelfServiceNoCashDrawer");
			buttons.addProductToCart("Apple");
			buttons.addProductToCart("Banana");
			
			System.out.println("Before Pay button: "+buttons.getPaymentAmount());
			
			buttons.payBtn();
			
			System.out.println("Payment Amount: "+buttons.getPaymentAmount());
			
			buttons.selectPaymentMethod("Cash");
			buttons.quickAmountButton("EXACT CHANGE");
			buttons.acceptTenderButton();
			buttons.noReceipt();
			buttons.usrOptionBtn();	
			
			buttons.signOffBtn();
			
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
			
			buttons.clickLoginB9();
			buttons.clickLoginB9();
			buttons.clickLoginB9();
			buttons.clickLoginB9();
			buttons.login();
			
			buttons.selectCashDrawer("SelfServiceNoCashDrawer");
			buttons.addProductToCart("Apple");
			buttons.addProductToCart("Banana");
			buttons.payBtn();
			
			//System.out.println("Payment Amount: "+buttons.getPaymentAmount());
			
			buttons.selectPaymentMethod("Cash");
			buttons.quickAmountButton("EXACT CHANGE");
			buttons.acceptTenderButton();
			buttons.noReceipt();
			buttons.usrOptionBtn();	
			
			buttons.signOffBtn();
		
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
			
			buttons.clickLoginB9();
			buttons.clickLoginB9();
			buttons.clickLoginB9();
			buttons.clickLoginB9();
			buttons.login();
			
			buttons.selectCashDrawer("SelfServiceNoCashDrawer");
			buttons.usrOptionBtn();
			
			System.out.println("User is: "+buttons.getUserName());
			
			buttons.signOffBtn();
			
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
	
	@Ignore
	@Test
	public void stub() {
		
	}

}
