package base;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static WebDriver driver;

	@Parameters({ "browser", "environment" })
	@BeforeTest(alwaysRun = true)
	public void setup(@Optional("chrome") String browser, @Optional("local") String environment) throws IOException {

		if (environment.equals("local")) {

			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
				System.out.println(browser + " Browser is launched");
			}
			if (browser.equals("MicrosoftEdge")) {
				driver = new EdgeDriver();
				System.out.println(browser + " Browser is launched");
			}
			if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
				System.out.println(browser + " Browser is launched");
			}
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}

		else if (environment.equals("seleniumgrid")) {
			URL url = URI.create("http://127.0.0.1:4444").toURL();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(browser);
			capabilities.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(url, capabilities);
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
	}

	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.quit();
		System.out.println("Browser is Closed ");

	}
}
