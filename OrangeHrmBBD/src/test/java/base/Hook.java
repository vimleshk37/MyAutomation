package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {
	public WebDriver driver;

	public void setup() {
		driver = new ChromeDriver();
		System.out.println(" Browser is launched");
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void teardown() {
		// driver.quit();
		System.out.println("Browser is Closed ");
	}
}
