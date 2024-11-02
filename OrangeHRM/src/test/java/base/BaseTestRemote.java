package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTestRemote {
	public static RemoteWebDriver driver;

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeTest(alwaysRun = true)
	public void setup(String browser) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browser);
		capabilities.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL("http://192.168.1.4:4444"), capabilities);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.quit();
		System.out.println("Browser is Closed ");

	}
}
