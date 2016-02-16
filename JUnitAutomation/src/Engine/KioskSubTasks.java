package Engine;

import org.apache.commons.lang3.StringUtils;

/**
 * KioskSubTasks.java
 * @author timconverse
 *
 * This file contains methods for doing repetitive tasks related to the kiosk
 * such as "login" or "logoff".  
 *
 */

public class KioskSubTasks {

	private KioskCSControls cashierService;
	
	/**
	 * Constructor - takes a reference to the KioskButtons
	 */
	public KioskSubTasks(KioskCSControls buttons) {
		this.cashierService = buttons;
		System.out.println("Initializing SubTasks.");
	}
	
	/**
	 * Login
	 * Takes a string.  If it recognizes "cashier" or "manager" then
	 * it executes the default logins.  If not, it assumes that the 
	 * string is the sequence of digits to be pressed.
	 * 
	 * Note: "cashier" and "manager" login information is defined
	 * in the Org record and for testing purposes we default them
	 * to "1111" and "9999" respectively.
	 */
	public boolean login(String type) {
		type = type.toLowerCase();
		
		switch(type) {
		case "cashier":
			//default cashier
			cashierService.clickLoginB1();
			cashierService.clickLoginB1();
			cashierService.clickLoginB1();
			cashierService.clickLoginB1();
			cashierService.login();
			return true;
		case "manager":
			//default manager
			cashierService.clickLoginB9();
			cashierService.clickLoginB9();
			cashierService.clickLoginB9();
			cashierService.clickLoginB9();
			cashierService.login();
			return true;
		default:
			// call parse login string
			parseLoginString(type);
			break;
		}
		
		//if we get to here then something bad happened.
		System.out.println("Login Failed");
		
		return false;
	}
	
	/**
	 * Parse Login String
	 * Takes a string and attempts to use it as a key combination for
	 * logging in.
	 */
	public boolean parseLoginString(String type) {
	//ToDo: Implement 
		String btn;
		
		if (StringUtils.isNumeric(type)) {
			
			for (int i=0; i<type.length(); i++ ){
				btn = type.substring(i,i);
					switch (btn) {
					case "0" :
						cashierService.clickLoginB0();
						break;
					case "1" :
						cashierService.clickLoginB1();
						break;
					case "2" :
						cashierService.clickLoginB2();
						break;
					case "3" :
						cashierService.clickLoginB3();
						break;
					case "4" :
						cashierService.clickLoginB4();
						break;
					case "5" :
						cashierService.clickLoginB5();
						break;
					case "6" :
						cashierService.clickLoginB6();
						break;
					case "7" :
						cashierService.clickLoginB7();
						break;
					case "8" :
						cashierService.clickLoginB8();
						break;
					case "9" :
						cashierService.clickLoginB9();
						break;
					}
				}
			return true;
		} else {
			System.out.println("Can't parse Login.");
			return false;
		}
	}
	
	/**
	 * Logout
	 */
	public boolean logout() {
		try {
			cashierService.usrOptionBtn();	
			cashierService.signOffBtn();
			return true;
		} catch (Exception e) {
			System.out.println("Failed to logout");
			System.out.println(e);
			return false;
		}
	}
	
	/**
	 * Reset Kiosk
	 * When a test fails we need to be able to reset the kiosk to a
	 * usable state for the next test.  Typically this means resetting
	 * the cashdrawer, but other tasks may be needed to reset it properly.
	 */
	
	public boolean resetKiosk(String drawer) {
		try {
			cashierService.usrOptionBtn();
			cashierService.manageCashDrawerBtn();
			cashierService.selectCashDrawer(drawer);
			return true;
		} catch (Exception e) {
			System.out.println("Failed Kiosk Clean up.");
			System.out.println(e);
			return false;
		}
	}
	
	
}
