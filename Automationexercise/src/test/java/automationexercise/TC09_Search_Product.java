package automationexercise;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC09_Search_Product implements Automationexercise_interface {
	BasicUtility BUtility = new BasicUtility();
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void start() {
		BUtility.LaunchWithAdBlock(url);
	}

	@Test
	public void Verify_All_Products() {

		BUtility.SwitchToParentWindow();
		// intentionally reloaded the page to avoid ads.
		BUtility.driver.navigate().refresh();
		Assert.assertEquals(BUtility.findElementIsPresent(Home_Page_Element), true);
		System.out.println("Homepage visibility --> " + BUtility.findElementIsPresent(Home_Page_Element) + "");
		BUtility.click_Left(Products_HomePage_Element);
		String Acutal_Titile = BUtility.driver.getTitle();
		System.out.println("Page Title --> " + Acutal_Titile);
		softAssert.assertEquals(Acutal_Titile, Expecte_Titile);
		BUtility.sendkeys(Search_Box_Element, Search_Text);
		BUtility.click_Left(Search_Element);
		softAssert.assertEquals(true, BUtility.findElementIsPresent(Product_Results_Elements));
		System.out.println("the product search results are fetched --> "
				+ BUtility.findElementIsPresent(Product_Results_Elements));

	}
	
	
	@AfterTest
	public void close() {
		BUtility.sleepSeconds(3);
		BUtility.quit();
	}
}