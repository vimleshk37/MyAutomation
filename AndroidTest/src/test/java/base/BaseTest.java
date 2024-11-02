package base;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;



public class BaseTest {
	public static AppiumDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException, URISyntaxException{
		URL serviceURL = new URI("http://127.0.0.1:4723/").toURL();
	 	DesiredCapabilities caps = new DesiredCapabilities();
	 	caps.setCapability("platformName", "Android");
	 	caps.setCapability("appium:appPackage", "com.org.AmarUjala.news");
	 	caps.setCapability("appium:appActivity", "com.org.AmarUjala.news.HomeActivity");
	 	caps.setCapability("appium:automationName", "uiautomator2");
	 	caps.setCapability("appium:udid", "137547384200071");
        //caps.setCapability("appium:ensureWebviewsHavePages", true);
        //caps.setCapability("appium:nativeWebScreenshot", true);
        //caps.setCapability("appium:newCommandTimeout", 3600);
        //caps.setCapability("appium:connectHardwareKeyboard", true);
        //caps.setCapability("appium:lastScrollData", "");

        driver = new AppiumDriver(serviceURL,caps);

	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		System.out.println("App is closed");
	}

}
