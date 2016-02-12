import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ADMFireFox.class, 
				KioskCSFireFox.class })

public class AllTests {
	
	public AllTests() {
		System.out.println("Running all Test Classes.");		
	}
	

}
