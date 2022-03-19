package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;

	// ==============Web Elements=======================//
	@FindBy(className = "login")
	WebElement LoginLink;

	@FindBy(name = "user_login")
	WebElement UserName;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(name = "btn_login")
	WebElement LoginBtn;

	@FindBy(className = "rememberMe")
	WebElement RememberMeChkBox;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	// ======================Functions====================//

	public void LoginFunction(String UserID, String UserPassword) {

		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login Link", "Login Link clicked successfully");
		
		UserName.sendKeys(UserID);
		test.log(LogStatus.PASS, "Enter UserName", "Username entered successfully");
		
		Password.sendKeys(UserPassword);
		test.log(LogStatus.PASS, "Enter Password", "Password entered successfully");
		
		RememberMeChkBox.click();
		test.log(LogStatus.PASS, "Click on Remeber Me", "Clicked successfully");
		
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Login Button clicked successfully");

	}

	public void UICheck() {
		Assert.assertTrue(UserName.isDisplayed());
	}

}
