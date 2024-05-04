package automationexercise;

import org.openqa.selenium.By;


public interface Automationexercise_interface {
	// Home Page Address (URL)
	String url = "http://automationexercise.com/";
	// Home page element
	By Home_Page_Element = By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");
	// WebElement HomePageElement = BUtility.driver.findElement(Home_Page_Element);
	// Signup/Login Button
	By Login_Button = By.xpath("//a[contains(@href,'/login')]");
	// Login page element
	By Login_Page_Element = By.xpath("//h2[text()='New User Signup!']");
	By Signup_Email_Element = By.xpath("//input[@data-qa='signup-email']");
	String Signup_Email = "Manohardhangar707@gmail.com";
	By Signup_Name = By.xpath("//input[@type='text']");
	String Name = "Manohar";
	By Singup_Submit = By.xpath("//*[@data-qa='signup-button']");
	// Signup Page--here
	By Signup_Page_Element = By.xpath("//*[text()='Enter Account Information']");
	By Title_Mr = By.xpath("//input[@name='title' and @id='id_gender1']");
	By Title_Mrs = By.xpath("//input[@name='title' and @id='id_gender2']");
	By Password_Element = By.xpath("//input[@type='password']");
	String Password = "Manohar@123";
	By DateOfBirth_Days_Element = By.xpath("//Select[@data-qa='days']");
	By DateOfBirth_Month_Element = By.xpath("//Select[@data-qa='months']");
	By DateOfBirth_Year_Element = By.xpath("//Select[@data-qa='years']");
	String Dropdown_text_Selectiom = "text";
	// Spliting Date into date, month & year
	String DOB = "20/April/2001";
	String[] parts = DOB.split("/");
	String DateOfBirth_Date = parts[0];
	String DateOfBirth_Month = parts[1];
	String DateOfBirth_Year = parts[2];
	By Newsletter_Element = By.xpath("//input[@name='newsletter']");
	By ReceiveSpecialOffers_Element = By.xpath("//input[@id='optin']");
	By FirstName_Element = By.xpath("//input[@id='first_name']");
	By LastName_Element = By.xpath("//input[@id='last_name']");
	String FullName = "Manohar Barma";
	String[] Nameparts = FullName.split(" ");
	String FirstName = Nameparts[0];
	String LastName = Nameparts[1];
	By Company_Element = By.xpath("//input[@id='company']");
	String Company_Name = "TechMahindra";
	By Address1_Element = By.xpath("//input[@id='address1']");
	String Address1 = "Survey No. 62, TMTC SEZ, 1 A";
	By Address2_Element = By.xpath("//input[@id='address2']");
	String Address2 = "Qutubullapur Mandal, Bahadurpally";
	By Country_Element = By.cssSelector("select#country");
	String Country_Name = "India";
	By State_Element = By.cssSelector("#state");
	String State_Name = "Telangana";
	By City_Element = By.cssSelector("#city");
	String City_Name = "Hyderabad";
	By ZipCode_Element = By.cssSelector("#zipcode");
	String ZipCode = "500043";
	By Company_MobileNumber_Element = By.cssSelector("#mobile_number");
	String Company_MobileNumber = "9999999999";
	By Create_Account_Button = By.xpath("//*[@data-qa='create-account']");
	// Account Created Page
	By Account_Created_Element = By.xpath("//*[text()='Account Created!']");
	By Continue_Created_Page_Element = By.xpath("//*[@data-qa='continue-button']");
	By Logged_In_As_Element = By.xpath("//*[@class='fa fa-user']");
	By Delete_Account_Element = By.xpath("//*[@href='/delete_account']");
	// Delete Account Page
	By Account_Deleted_Element = By.xpath("//*[text()='Account Deleted!']");
	By Continue_Delete_Page_Element = By.xpath("//*[@data-qa='continue-button']");
	// Add Dismiss
	By Add_Dismiss_Element = By.xpath("/html/body/div/div/div[1]/div[1]/div[1]");
	// ====================================================================== //

	// From Here -- Login_With_Correct_Email_And_Password-- TestCase 02 //
	By Login_Email_Element = By.xpath("//*[@type='email' and @data-qa='login-email']");
	String Login_Email = "Manohardhangar777@gmail.com";
	By Login_Submit_Element = By.xpath("//*[@data-qa='login-button']");
	By Login_Password_Element = By.xpath("//*[@data-qa='login-password']");
	String Login_Password = "Manohar@123";
	// ====================================================================== //

	// From Here -- Login_With_InCorrect_Email_And_Password-- TestCase 03 //

	String Login_Incorrect_Email = "Admin234@gmail.com";
	String Login_Incorrect_Password = "Admin@234";
	By Incorrect_Email_Password_Element = By.xpath("//*[text()='Your email or password is incorrect!']");
	// ====================================================================== //

	// From Here -- Login_With_Correct_Email_And_Password-- TestCase 04 //

	By Logout_Element = By.xpath("//*[@href='/logout']");
	// ====================================================================== //

	// From Here -- Login_With_Existing_Email_And_Password-- TestCase 05 //

	By Email_Already_Exist_Element = By.xpath("//*[text()=\"Email Address already exist!\"]");
	// ====================================================================== //

	// From Here -- Contact Us Form -- TestCase 06 //

	By ContactUs_Element = By.xpath("//a[@href=\"/contact_us\"]");
	By ContactUs_Name_Element = By.cssSelector("input[data-qa=name]");
	By ContactUs_Email_Element = By.cssSelector("input[data-qa=email]");
	By ContactUs_Subject_Element = By.cssSelector("input[data-qa=subject]");
	String ContactUs_Subject = "Software Testing Practice By Manohar Barma";
	By ContactUs_Message_Element = By.cssSelector("textarea[data-qa=message]");
	String ContactUs_Message = "Hi there, Feeling Confident after this Practice\nThanks for creating this wonderful website for testing practice";
	By Choose_File_Element = By.cssSelector("input[name=upload_file]");
	String Choose_File_Path = "C:\\Users\\Barma manohar\\eclipse-workspace\\firstsample\\Upload_Files\\2Stroke_Engines.txt";
	By ContactUs_Submit_Element = By.cssSelector("input[type=submit]");
	By ContactUs_Form_Success_Element = By.cssSelector("div.status.alert.alert-success");
	By Home_Element = By.cssSelector("i.fa.fa-home");
	// ====================================================================== //

	
	// From Here -- Visibility of TestCases Page -- TestCase 07 //
	
	By TestCases_Element = By.xpath("(//a[@href=\"/test_cases\"])[1]");
	By TestCases_Page_Element = By.xpath("//b[text()='Test Cases']");
	// ====================================================================== //
	
	
	// From Here -- Visibility of All Products and Product Detail page -- TestCase 08 //
	
	By Product_Name_Element = By.xpath("//h2[text()='Blue Top']");
	By Products_HomePage_Element = By.xpath("//*[@href=\"/products\"]");
	By All_Products_Element = By.cssSelector("div.single-products");
	By First_Product_View_Element = By.xpath("//a[@href=\"/product_details/1\"]");
	String Expecte_Titile = "Automation Exercise - All Products";
	By Category_Element = By.xpath("//p[text()='Category: Women > Tops']");
	By Price_Element = By.xpath("//span[text()='Rs. 500']");
	By Availability_Element = By.xpath("//b[contains(text(), 'Availability:')]");
	By Condition_Element = By.xpath("//b[contains(text(), 'Condition:')]");
	By Brand_Element = By.xpath("//b[contains(text(), 'Brand:')]");
	By[] Product_Detail_Elements = { Product_Name_Element, Category_Element, Price_Element, Availability_Element,
			Condition_Element, Brand_Element };
	// ====================================================================== //
	
	
	// From Here -- Search Product And Results -- TestCase 09 //
	
	By Search_Box_Element = By.cssSelector("input.form-control.input-lg");
	String Search_Text = "Little Girls Mr. Panda Shirt";
	By Search_Element = By.cssSelector("button.btn.btn-default.btn-lg");
	By Product_Results_Elements = By.xpath("//p[contains(text(),'"+Search_Text+"')]");
	// ====================================================================== //
}
