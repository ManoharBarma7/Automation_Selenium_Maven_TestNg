package automationexercise;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC05_RegisterUser_With_Existing_Email implements Automationexercise_interface {
	// Basic Utility class instance
	BasicUtility BUtility = new BasicUtility();

	@BeforeTest
	public void start() {
		//BUtility.Launch(url);
		BUtility.LaunchWithAdBlock(url);
	
		
	}

	@Test
	public void RegisterPage() {
		BUtility.SwitchToParentWindow();
		// intentionally reloaded the page to avoid ads.
		BUtility.driver.navigate().refresh();
		Assert.assertEquals(BUtility.findElementIsPresent(Home_Page_Element), true);
		System.out.println("Homepage visibility --> " + BUtility.findElementIsPresent(Home_Page_Element) + "");
		BUtility.click_Left(Login_Button);
		Assert.assertEquals(BUtility.findElementIsPresent(Login_Page_Element), true);
		System.out.println("Login Page visibility --> " + BUtility.findElementIsPresent(Login_Page_Element) + "");
		BUtility.sendkeys(Signup_Email_Element, Login_Email);
		BUtility.sendkeys(Signup_Name, Name);
		BUtility.click_Left(Singup_Submit);
		
		Assert.assertEquals(BUtility.findElementIsPresent(Email_Already_Exist_Element), true);
		System.out.println("Email Already Exist --> " + BUtility.findElementIsPresent(Login_Page_Element) + "");

	}
	@AfterTest
	public void End() {
		BUtility.quit();
	}
	
}
