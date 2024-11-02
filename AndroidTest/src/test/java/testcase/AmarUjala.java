package testcase;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class AmarUjala extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(priority = 0)
	public static void AmarUjalaopen() throws MalformedURLException, InterruptedException, URISyntaxException {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		System.out.println("SessionId is " + driver.getSessionId());
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public static void AmarUjalaGetEpaper() throws MalformedURLException, InterruptedException, URISyntaxException {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		System.out.println("SessionId is " + driver.getSessionId());
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();

		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath(
				"(//android.widget.ImageView[@resource-id=\"com.org.AmarUjala.news:id/navigation_menu_icon\"])[2]"))
				.click();

		driver.findElement(
				By.xpath("//android.widget.Button[@resource-id=\"com.org.AmarUjala.news:id/btn_gmail_login\"]"))
				.click();

		driver.findElement(By.xpath(
				"(//android.widget.LinearLayout[@resource-id=\"com.google.android.gms:id/container\"])[1]/android.widget.LinearLayout"))
				.click();

		driver.findElement(
				By.xpath("(//android.widget.ImageView[@resource-id=\"com.org.AmarUjala.news:id/imageView\"])[1]"))
				.click();

		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id=\"com.org.AmarUjala.news:id/textview_second\"]"))
				.click();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.org.AmarUjala.news:id/edit_text\"]"))
				.sendKeys("sitapur");
		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id=\"com.org.AmarUjala.news:id/textView_main\"]"))
				.click();

		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id=\"com.org.AmarUjala.news:id/tvSupplement\"]")).click();
		driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id=\"com.org.AmarUjala.news:id/skip_button\" and @text=\"My City\"]"))
				.click();

	}
}
