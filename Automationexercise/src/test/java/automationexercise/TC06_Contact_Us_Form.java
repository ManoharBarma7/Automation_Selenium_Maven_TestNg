package automationexercise;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC06_Contact_Us_Form implements Automationexercise_interface {
	BasicUtility BUtility = new BasicUtility();

	@BeforeTest
	public void start() {
		BUtility.LaunchWithAdBlock(url);

	}

	@Test
	public void Contact_Us_Form() {

		BUtility.SwitchToParentWindow();
		// intentionally reloaded the page to avoid ads.
		BUtility.sleepSeconds(3);
		BUtility.driver.navigate().refresh();
		Assert.assertEquals(BUtility.findElementIsPresent(Home_Page_Element), true);
		System.out.println("Homepage visibility --> " + BUtility.findElementIsPresent(Home_Page_Element) + "");
		BUtility.click_Left(ContactUs_Element);
		BUtility.sendkeys(ContactUs_Name_Element, Name);
		BUtility.sendkeys(ContactUs_Email_Element, Login_Email);
		BUtility.sendkeys(ContactUs_Subject_Element, ContactUs_Subject);
		BUtility.sendkeys(ContactUs_Message_Element, ContactUs_Message);
		System.out.println("Message Sent --> " + ContactUs_Message);
		BUtility.UploadFile(Choose_File_Element, Choose_File_Path);
		BUtility.click_Left(ContactUs_Submit_Element);
		Alert alert = BUtility.driver.switchTo().alert();
		alert.accept();
		Assert.assertEquals(BUtility.findElementIsPresent(ContactUs_Form_Success_Element), true);
		System.out.println(
				"Form Submission Success  --> " + BUtility.findElementIsPresent(ContactUs_Form_Success_Element));
		BUtility.click_Left(Home_Element);
		Assert.assertEquals(BUtility.findElementIsPresent(Home_Page_Element), true);
		System.out.println("Homepage visibility --> " + BUtility.findElementIsPresent(Home_Page_Element) + "");

	}

	@AfterTest
	public void close() {
		BUtility.sleepSeconds(3);
		BUtility.quit();
	}

}
