package testcase;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class GetYourKundli extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public static void YourKundli() throws IOException, InterruptedException {
		// Get Kundali From (https://www.astroyogi.com/)
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//ul[@id='menu']/li[8]")).click();
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//input[@id='Kund_Name']")).sendKeys("Vimlesh Kumar");

		Select objSelect1 = new Select(driver.findElement(By.xpath("//select[@id='UserGender']")));
		objSelect1.selectByValue("Male");

		Select date = new Select(driver.findElement(By.xpath("//select[@id='Date']")));
		date.selectByValue("3");

		Select month = new Select(driver.findElement(By.xpath("//select[@id='Month']")));
		month.selectByValue("7");

		Select year = new Select(driver.findElement(By.xpath("//select[@id='Year']")));
		year.selectByValue("1982");

		Select Birth_Hour = new Select(driver.findElement(By.xpath("//select[@id='Kund_F_BirthPlace_Hour']")));
		Birth_Hour.selectByVisibleText("12");

		Select Birth_Minute = new Select(driver.findElement(By.xpath("//select[@id='Kund_F_BirthPlace_Minute']")));
		Birth_Minute.selectByVisibleText("35");

		Select Birth_AMPM = new Select(driver.findElement(By.xpath("//select[@id='Kund_F_BirthPlace_AM']")));
		Birth_AMPM.selectByVisibleText("PM");

		WebElement BirthPlace = driver.findElement(By.xpath("//input[@id='Kund_BirthPlace']"));
		String place = "Delhi";
		for (int i = 0; i < place.length(); i++) {
			char ch = place.charAt(i);
			String p = Character.toString(ch);
			BirthPlace.sendKeys(p);
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		}
		List<WebElement> birthPlaces = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		for (WebElement birthPlace : birthPlaces) {
			if (birthPlace.getText().equals("Delhi North East, Delhi, IN"))
				birthPlace.click();
		}

		driver.findElement(By.xpath("//button[@id='kundli_submit']")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		if (driver.getTitle().equals("Check your Kundli Report"))
			System.out.println("Kundli is Created Sucessfully");
		else
			System.out.println("Kundli is not Created some issue is there");

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\OutputData\\Kundali.jpeg"));
	}
}