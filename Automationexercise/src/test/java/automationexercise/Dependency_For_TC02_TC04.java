package automationexercise;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dependency_For_TC02_TC04
		implements Automationexercise_interface {
	BasicUtility BUtility = new BasicUtility();

	@BeforeTest
	public void start() {
		BUtility.LaunchWithAdBlock(url);

	}

	@Test
	public void UserRegiserForLogin() {

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
		Assert.assertEquals(BUtility.findElementIsPresent(Signup_Page_Element), true);
		System.out.println("Signup Page visibility --> " + BUtility.findElementIsPresent(Signup_Page_Element) + "");
		BUtility.sendkeys(Password_Element, Password);
		BUtility.selectFromDropdown(DateOfBirth_Days_Element, Dropdown_text_Selectiom, DateOfBirth_Date);
		BUtility.selectFromDropdown(DateOfBirth_Month_Element, Dropdown_text_Selectiom, DateOfBirth_Month);
		BUtility.selectFromDropdown(DateOfBirth_Year_Element, Dropdown_text_Selectiom, DateOfBirth_Year);
		BUtility.click_Left(Newsletter_Element);
		BUtility.click_Left(ReceiveSpecialOffers_Element);
		BUtility.sendkeys(FirstName_Element, FirstName);
		BUtility.sendkeys(LastName_Element, LastName);
		BUtility.sendkeys(Company_Element, Company_Name);
		BUtility.sendkeys(Address1_Element, Address1);
		BUtility.sendkeys(Address2_Element, Address2);
		BUtility.sendkeys(Country_Element, Country_Name);
		BUtility.sendkeys(State_Element, State_Name);
		BUtility.sendkeys(City_Element, City_Name);
		BUtility.sendkeys(ZipCode_Element, ZipCode);
		BUtility.sendkeys(Company_MobileNumber_Element, Company_MobileNumber);
		BUtility.click_Left(Create_Account_Button);
		Assert.assertEquals(BUtility.findElementIsPresent(Account_Created_Element), true);
		System.out
				.println("Account Creation Status --> " + BUtility.findElementIsPresent(Account_Created_Element) + "");
		BUtility.click_Left(Continue_Created_Page_Element);
	}

	@AfterTest
	public void Close() {
		BUtility.quit();
	}
}
