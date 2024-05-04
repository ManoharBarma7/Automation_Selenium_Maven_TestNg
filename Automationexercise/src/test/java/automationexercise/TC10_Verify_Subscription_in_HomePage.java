package automationexercise;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC10_Verify_Subscription_in_HomePage implements Automationexercise_interface {
	BasicUtility BUtility = new BasicUtility();
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void start() {
		BUtility.LaunchWithAdBlock(url);
	}

	@Test
	public void Verify_Subscription() {
// hbhhkjh
		BUtility.SwitchToParentWindow();
		// intentionally reloaded the page to avoid ads.
		BUtility.driver.navigate().refresh();
		Assert.assertEquals(BUtility.findElementIsPresent(Home_Page_Element), true);
		System.out.println("Homepage visibility --> " + BUtility.findElementIsPresent(Home_Page_Element) );
		BUtility.scrollToBottom(BUtility.driver);
		
		
		By Subscription_Element = By.xpath("//*[text()=\"Subscription\"]");
		String Email_Dummy= "Manohar000@gmail.com";
		By Subscription_Box_Element = By.cssSelector("input#susbscribe_email");
		By Subscription_Submit_Element = By.cssSelector("button#subscribe");
		By Sub_Sucess_Element = By.cssSelector("div#success-subscribe");
		
		Assert.assertEquals(BUtility.findElementIsPresent(Subscription_Element), true);
		System.out.println("Subscription visibility --> " + BUtility.findElementIsPresent(Subscription_Element) );
		BUtility.sendkeys(Subscription_Box_Element, Email_Dummy);
		BUtility.click_Left(Subscription_Submit_Element);
		Assert.assertEquals(BUtility.findElementIsPresent(Sub_Sucess_Element), true);
		System.out.println("Success Message visibility --> " + BUtility.findElementIsPresent(Sub_Sucess_Element) );
	
		
		
		
	}
	
	@AfterTest
	public void close() {
		BUtility.sleepSeconds(3);
		BUtility.quit();
	}
}