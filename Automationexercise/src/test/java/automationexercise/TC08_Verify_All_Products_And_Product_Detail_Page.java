package automationexercise;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC08_Verify_All_Products_And_Product_Detail_Page implements Automationexercise_interface {
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
		List<WebElement> All_Products = BUtility.driver.findElements(All_Products_Element);
		softAssert.assertNotEquals(All_Products.size(), 0);
		BUtility.click_Left(First_Product_View_Element);
		BUtility.verifyElementVisibility(BUtility.driver, Product_Detail_Elements);
		

	}
}