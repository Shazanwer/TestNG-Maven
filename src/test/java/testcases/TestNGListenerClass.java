package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenerClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("============TestStarted========");
		// not implemented
	}

	public void onTestFailure(ITestResult result) {
		// not implemented
		TakesScreenshot obj = (TakesScreenshot) BaseClass.driver;

		File file = obj.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(".//Screenshot//image1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
