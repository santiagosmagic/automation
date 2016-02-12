import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ADMFireFox {

	static WebDriver driverADM = new FirefoxDriver();
	static InputFields fieldsADM = new InputFields();
	
	@Before
	public void setup(){
		String admIP = "http://192.168.59.225:2290/capadm/public/login";
		driverADM.get(admIP);
		String j = driverADM.getCurrentUrl();
		System.out.println(j);
	}
	
	@After
	public void close() {
		//driverADM.close();
	}
	
	@Test
	public void loginADM() {
		fieldsADM.username("tim@readytouch.com");
		fieldsADM.password("rts");
	}
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
