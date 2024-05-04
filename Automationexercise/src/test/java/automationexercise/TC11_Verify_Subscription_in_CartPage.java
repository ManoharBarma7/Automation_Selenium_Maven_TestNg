package automationexercise;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC11_Verify_Subscription_in_CartPage implements Automationexercise_interface {
	BasicUtility BUtility = new BasicUtility();
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void start() {
		BUtility.LaunchWithAdBlock(url);
	}

	@Test
	public void Verify_Subscription() {

		BUtility.SwitchToParentWindow();
		// intentionally reloaded the page to avoid ads.
		BUtility.driver.navigate().refresh();
		Assert.assertEquals(BUtility.findElementIsPresent(Home_Page_Element), true);
		System.out.println("Homepage visibility --> " + BUtility.findElementIsPresent(Home_Page_Element));
		BUtility.click_Left(Cart_Button);
		Assert.assertEquals(BUtility.findElementIsPresent(CartPage_Element), true);
		System.out.println("Cartpage visibility --> " + BUtility.findElementIsPresent(CartPage_Element));
		BUtility.scrollToBottom(BUtility.driver);
		Assert.assertEquals(BUtility.findElementIsPresent(Subscription_Element), true);
		System.out.println("Subscription visibility --> " + BUtility.findElementIsPresent(Subscription_Element));
		BUtility.sendkeys(Subscription_Box_Element, Email_Dummy);
		BUtility.click_Left(Subscription_Submit_Element);
		Assert.assertEquals(BUtility.findElementIsPresent(Sub_Sucess_Element), true);
		System.out.println("Success Message visibility --> " + BUtility.findElementIsPresent(Sub_Sucess_Element));
	}

	@AfterTest
	public void close() {
		BUtility.sleepSeconds(3);
		BUtility.quit();
	}
}