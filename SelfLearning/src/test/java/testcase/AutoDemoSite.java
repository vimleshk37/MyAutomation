package testcase;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class AutoDemoSite extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(enabled = true, groups={"vimlesh"})
	public static void RegisterUser() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Vimlesh");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("B 22 Naraottam Nagar");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.xpath("//input[@value='Cricket']")).click();

		// Select Languages from Drop down
		driver.findElement(By.xpath("//div[@id='msdd']")).click();
		List<WebElement> languages = driver.findElements(By.xpath("//*[@style='text-decoration:none']"));
		for (WebElement language : languages) {
			if (language.getText().equals("English"))
				language.click();
			if (language.getText().equals("Hindi"))
				language.click();
		}
		driver.findElement(By.xpath("//div[@class='row ']")).click();

		// Select Skills from Drop down
		WebElement skills = driver.findElement(By.xpath("//select[@id='Skills']"));
		skills.click();
		Select Selectskill = new Select(skills);
		Selectskill.selectByValue("Linux");

		//// Select Country from Drop down
		driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']")).click();
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);

		// Select Date Of Birth from Drop down
		WebElement year = driver.findElement(By.xpath("//select[@id='yearbox']"));
		skills.click();
		Select Selectyear = new Select(year);
		Selectyear.selectByValue("1992");

		WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		skills.click();
		Select Selectmonth = new Select(month);
		Selectmonth.selectByValue("July");

		WebElement day = driver.findElement(By.xpath("//select[@id='daybox']"));
		skills.click();
		Select Selectday = new Select(day);
		Selectday.selectByValue("3");

		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true)
	public static void AlertsHandling() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@href='SwitchTo.html']")).click();
		driver.findElement(By.xpath("//*[@href='Alerts.html']")).click();

		// driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();

		// driver.findElement(By.xpath("//*[@href='#CancelTab']")).click();
		// driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

		driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
		driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

		try {
			Alert alart = driver.switchTo().alert();
			System.out.println("alert was present");
			System.out.println(alart.getText());
			alart.sendKeys("Aaradhya");
			alart.accept();
		} catch (NoAlertPresentException Ex) {
			System.out.println("alert was not present");
		}

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public static void WindowsHandling() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@href='SwitchTo.html']")).click();
		driver.findElement(By.xpath("//*[@href='Windows.html']")).click();
		String parentHandle = driver.getWindowHandle();
		// driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

		// driver.findElement(By.xpath("//*[@href='#Seperate']")).click();
		// driver.findElement(By.xpath("//button[@onclick='newwindow()']")).click();

		driver.findElement(By.xpath("//*[@href='#Multiple']")).click();
		driver.findElement(By.xpath("//button[@onclick='multiwindow()']")).click();

		Set<String> allHandle = driver.getWindowHandles();
		for (String handle : allHandle) {
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				if (driver.getTitle().equals("Selenium"))
					break;
			}
		}
		System.out.println(driver.getTitle());
		// String childHandle = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		Assert.assertEquals(driver.getTitle(), "Selenium");
		driver.findElement(By.xpath("//*[@href='/downloads']")).click();
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public static void iFrameHandling() {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@href='SwitchTo.html']")).click();
		driver.findElement(By.xpath("//*[@href='Frames.html']")).click();
		driver.findElement(By.xpath("//*[@href='#Multiple']")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[@style='float: left;height: 250px;width: 400px']")));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Vimlesh");
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public static void autocomplete() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@href='Widgets.html']")).click();
		driver.findElement(By.xpath("//*[@href='AutoComplete.html']")).click();

		driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys("United");

		List<WebElement> searchResult = driver.findElements(By.xpath("//*[@class=\"ui-menu-item\"]"));
		for (WebElement search : searchResult) {
			if (search.getText().equals("United Kingdom")) {
				search.click();
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public static void DatePicker() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@href='Widgets.html']")).click();
		driver.findElement(By.xpath("//*[@href='Datepicker.html']")).click();

		driver.findElement(By.xpath("//img[@class='imgdp']")).click();
		// Date Selection
		List<WebElement> dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']/a"));
		for (WebElement date : dates) {
			if (date.getText().equals("30"))
				date.click();
		}
	}
}