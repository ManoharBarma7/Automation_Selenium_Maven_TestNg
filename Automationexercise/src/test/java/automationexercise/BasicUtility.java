package automationexercise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BasicUtility {

	WebDriver driver;
	WebDriverWait wait;

	public BasicUtility() {
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("./Extensions/Adblock.crx"));
		driver = new ChromeDriver(opt);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Launch URL with Add Blocker
	public void LaunchWithAdBlock(String Url) {
		driver.manage().window().maximize();
		driver.get(Url);
		System.out.println("!! Browser is Launched with AdBlocker --> " + Url);
	}

	// Window Maximise
	public void max() {
		driver.manage().window().maximize();
	}

	// Click (Input Xpath)
	public void click_Left(By Locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			driver.findElement(Locator).click();
		} catch (Exception e) {
			System.out.println("Exception occurred while clicking element: " + e.getMessage());
		}
	}

	// SendKeys (Input 1.Xpath, 2.InputText)
	public void sendkeys(By Locator, String Text) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			WebElement element = driver.findElement(Locator);
			element.sendKeys(Text);
		} catch (Exception e) {
			System.out.println("Exception occurred while sending keys: " + e.getMessage());
		}
	}

	// Get Text
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	// Takes screenshot of webelement
	public void GetScreenshotOfElement(By locator, String PathandName) {
		WebElement b = driver.findElement(locator);
		File file = b.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(PathandName));
			System.out.println("Screenshot is saved in (" + PathandName + ")");
		} catch (IOException e) {
			System.out.println("Error occurred at screenshot(" + locator + ") block");
			e.printStackTrace();
		}
	}

	// Takes Full screen screenshot
	public void GetScreenshotFullScreen(String Path) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(Path));
			System.out.println("Screenshot is saved in (" + Path + ")");
		} catch (IOException e) {
			System.out.println("Error occurred at screenshot(entire screen) block");
			e.printStackTrace();
		}

	}

	// Gives Element presence
	public boolean findElementIsPresent(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element.isDisplayed();
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			// Log or handle the exception as needed
			return false; // Return false if element is not found or stale
		}
	}

// select element form dropdown (uses select class)
	public void selectFromDropdown(By element, String selectionType, String value) {
		WebElement dropdownElement = driver.findElement(element);
		Select dropdown = new Select(dropdownElement);

		switch (selectionType.toLowerCase()) {
		case "text":
			dropdown.selectByVisibleText(value);
			break;
		case "index":
			int index = Integer.parseInt(value);
			dropdown.selectByIndex(index);
			break;
		case "value":
			dropdown.selectByValue(value);
			break;
		default:
			throw new IllegalArgumentException("Invalid selection type: " + selectionType);
		}
	}

	// Switch to the parent window
	public void SwitchToParentWindow() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		// Get the parent window handle
		String parentId = it.next();
		driver.switchTo().window(parentId);
		// sleep is added to improve ads handling
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Thread.sleep
	public void sleepSeconds(int sec) {
		int msec = sec * 1000;
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// for Uploading Files
	public void UploadFile(By Element, String filePath) {
		WebElement fileInput = driver.findElement(Element);
		fileInput.sendKeys(filePath);
	}

	// For Elements Visibility
	public void verifyElementVisibility(WebDriver driver, By[] Elements) {
	    SoftAssert softAssert = new SoftAssert();
	    boolean allVisible = true; // Assume all elements are initially visible
	    for (By EachElement : Elements) {
	        WebElement detailElement = null;
	        try {
	            detailElement = driver.findElement(EachElement);
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            // Element not found, assert as false
	            softAssert.fail("Element not found: " + EachElement.toString());
	            continue;
	        }
	        if (detailElement != null) {
	            softAssert.assertTrue(detailElement.isDisplayed(), "Element not visible: " + EachElement.toString());
	            // If any element is not visible, set allVisible to false
	            if (!detailElement.isDisplayed()) {
	                allVisible = false;
	            }
	        }
	    }
	    // If allVisible is still true after checking all elements, then print the message
	    if (allVisible) {
	        System.out.println("--  All elements are visible  --" );
	    }
	    softAssert.assertAll();
	}


	
	
	
	
	
	
	
	
	
	
	
	// Browser Quit
	public void quit() {

		driver.quit();
		System.out.println("Browser Closed..!!");
	}
}
