package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

@Listeners(TestNGListenerClass.class)

public class LoginTest extends BaseClass {

	@Test
	public void LoginFailureTest() {
//		test = report.startTest("ExternalDataTest");
		LoginPage lPage = new LoginPage();
		lPage.LoginFunction("xyz@abc.com", "Abcd@123");
		WebElement msgbox = driver.findElement(By.id("msg_box"));
		String Errormsg = msgbox.getText();
		String ActErrorMsg = "The email or password you have entered is invalid.";
		Assert.assertEquals(Errormsg, ActErrorMsg);
		report.endTest(test);
	}

	@Test
	public void LoginSuccessTest() {

		LoginPage lPage = new LoginPage();
		lPage.LoginFunction("xyz@abc.com", "Abcd@123");

	}

	@Test
	@Parameters({ "Param1", "Param2" })
	public void ParameterizedTest(String UserNameVal, String PasswordVal) {

		LoginPage lPage = new LoginPage();
		lPage.LoginFunction(UserNameVal, PasswordVal);
	}

	@Test
	public void ExternalDataTest() {

		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		LoginPage lPage = new LoginPage();
		lPage.LoginFunction(UserNameVal, PasswordVal);

	}

}
