package automationexercise;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC02_Login_With_Correct_Email_and_Password 
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
		BUtility.sendkeys(Login_Email_Element, Login_Email);
		BUtility.sendkeys(Login_Password_Element, Login_Password);
		BUtility.click_Left(Login_Submit_Element);
		Assert.assertEquals(BUtility.findElementIsPresent(Logged_In_As_Element), true);
		System.out.println("Logged In Status --> " + BUtility.findElementIsPresent(Logged_In_As_Element) + "");
		BUtility.click_Left(Delete_Account_Element);
		BUtility.findElementIsPresent(Account_Deleted_Element);
		BUtility.click_Left(Continue_Delete_Page_Element);
		System.out.println("Account Deleted !!");


	}

	@AfterTest
	public void close() {
		BUtility.quit();
	}

}
