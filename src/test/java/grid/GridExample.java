package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GridExample {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("chrome");
		URL url = new URL("http://192.168.100.48:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, cap);

		driver.get("https://www.simplilearn.com");

		driver.manage().window().maximize();

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(LoginLink)); // explicit wait

		LoginLink.click();

		driver.quit();

	}
}
