package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeTest(alwaysRun = true)
	public void setup(String browser) throws IOException {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			System.out.println(browser + " Browser is launched");
		}
		if (browser.equals("edge")) {
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

	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.quit();
		System.out.println("Browser is Closed ");

	}
}
