package automationexercise;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC03_Login_With_Incorrect_Email_and_Password
		implements Automationexercise_interface {
	BasicUtility BUtility = new BasicUtility();

	@BeforeTest
	public void start() {
		BUtility.LaunchWithAdBlock(url);

	}


	@Test 
	public void Login_With_Correct_Email_And_Password() {
		BUtility.SwitchToParentWindow();
		// intentionally reloaded the page to avoid ads.
		BUtility.driver.navigate().refresh();
		Assert.assertEquals(BUtility.findElementIsPresent(Home_Page_Element), true);
		System.out.println("Homepage visibility --> " + BUtility.findElementIsPresent(Home_Page_Element) + "");
		BUtility.click_Left(Login_Button);
		Assert.assertEquals(BUtility.findElementIsPresent(Login_Page_Element), true);
		System.out.println("Login Page visibility --> " + BUtility.findElementIsPresent(Login_Page_Element) + "");
		BUtility.sendkeys(Login_Email_Element, Login_Incorrect_Email);
		BUtility.sendkeys(Login_Password_Element, Login_Incorrect_Password);
		BUtility.click_Left(Login_Submit_Element);
		Assert.assertEquals(BUtility.findElementIsPresent(Incorrect_Email_Password_Element), true);
		System.out.println("Worng Password Status --> " + BUtility.findElementIsPresent(Incorrect_Email_Password_Element) + "");

	}

	@AfterTest
	public void End() {
		BUtility.quit();
	}
}
