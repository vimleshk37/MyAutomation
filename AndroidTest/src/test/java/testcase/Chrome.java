package testcase;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Chrome {
	public static AndroidDriver driver;

	@SuppressWarnings("deprecation")
	@Test(enabled = true)
	public static void OpenYoutube() throws MalformedURLException, InterruptedException, URISyntaxException {

		URL serverUri = new URI("http://127.0.0.1:4723/").toURL();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "uiautomator2");
		caps.setCapability("appium:udid", "137547384200071");
		caps.setCapability("appium:appPackage", "com.android.chrome");
		caps.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("appium:unicodeKeyboard", "true");
		caps.setCapability("appium:resetKeyboard", "true");

		driver = new AndroidDriver(serverUri, caps);
		
		System.out.println("Chrome is launched now");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("com.android.chrome:id/signin_fre_continue_button")).click();
		driver.findElement(By.id("com.android.chrome:id/button_primary")).click();
		driver.findElement(By.id("com.android.chrome:id/ack_button")).click();
	

		driver.findElement(By.id("com.android.chrome:id/search_box_text")).click();
	
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("com.android.chrome:id/url_bar")).sendKeys("https://www.flipkart.com/");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		//Activity activity= new Activity("com.vivo.calculator", "com.vivo.calculator.Calculator");
		//driver.startActivity(activity);
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//android.view.View[@text=\"Discover More\"]"));
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"input-searchsearchpage-input\"]")).sendKeys("Samsung");
		driver.findElement(By.xpath("//android.view.View[@text=\"samsung s24 ultra\"]")).click();
	}

}
