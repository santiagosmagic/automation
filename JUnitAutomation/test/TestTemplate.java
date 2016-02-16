/**
 * Test Template
 * 
 * Use this template file for creating any new test cases.
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Engine.KioskCSControls;
import Engine.KioskSubTasks;

public class TestTemplate {
	
	//======================================================
	// Establish class level variables here.
	// This is where you will set up handles to 'engine'
	// files.
	//======================================================
	
	static KioskCSControls cs = new KioskCSControls();
	static KioskSubTasks tasks = new KioskSubTasks(cs);
	static int testcount;	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		// Use this to set up any class level steps such as
		// connecting to a Kiosk and loading any 'engine'
		// components needed for this specific test class.
		
		// Initialize 'testcount'
		testcount = 0;
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		// Close out handles to 'engine' components here.
		
		cs.closeKiosk();
		
	}

	@Before
	public void setUp() throws Exception {
		
		// Runs before every individual test.  Use this to
		// increment 'testcount' and to provide output dividers
		// for results.
		
		testcount = testcount+1;
		System.out.println("Test Count " + testcount);
		System.out.println("");
	}

	@After
	public void tearDown() throws Exception {
		
		// Runs after every individual test.  Shows final
		// results and provides output dividers.
		
		System.out.println("End Test: " + testcount);
		System.out.println("=============================================");
		System.out.println("");
		
	}

	@Test
	public void test() {
		
		// Every test should use the following structure.
		
		// First output the test name and a simple description.
		System.out.println("Test Name: This Test looks for X.");
		
		// Implement test in Try/Catch structure
		try {
			//test body
		} catch (Exception e) {
			//If test fails to execute at all
			System.out.println("Test Failed" + e);
			fail("Test Failed.");
		}
		
	}

}
