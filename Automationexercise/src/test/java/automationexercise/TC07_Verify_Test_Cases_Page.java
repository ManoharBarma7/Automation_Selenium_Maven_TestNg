package automationexercise;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC07_Verify_Test_Cases_Page implements Automationexercise_interface {
	BasicUtility BUtility = new BasicUtility();

	@BeforeTest
	public void start() {
		BUtility.LaunchWithAdBlock(url);

	}

	@Test
	public void Visiblity_Test_Cases_Page() {

		BUtility.SwitchToParentWindow();
		// intentionally reloaded the page to avoid ads.
		BUtility.sleepSeconds(3);
		BUtility.driver.navigate().refresh();
		Assert.assertEquals(BUtility.findElementIsPresent(Home_Page_Element), true);
		System.out.println("Homepage visibility --> " + BUtility.findElementIsPresent(Home_Page_Element) + "");
		BUtility.click_Left(TestCases_Element);
		Assert.assertEquals(BUtility.findElementIsPresent(TestCases_Page_Element), true);
		System.out.println("Test Case Visibility --> " + BUtility.findElementIsPresent(TestCases_Page_Element));

	}

	@AfterTest
	public void close() {
		BUtility.sleepSeconds(3);
		BUtility.quit();
	}

}
