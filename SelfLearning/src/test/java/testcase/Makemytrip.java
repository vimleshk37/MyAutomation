package testcase;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Makemytrip {

	@SuppressWarnings("deprecation")
	@Test(enabled=false)
	public static void EaseMyTripSelectFlight() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.easemytrip.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		//driver.findElement(By.xpath("//*[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//button[@onclick='SearchFlightWithArmyTest();']")).click();

		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		List<WebElement> flightsNumber = driver.findElements(By.xpath("//span[@class='txt-r5']"));
		List<WebElement> booknow = driver.findElements(By.xpath("//button[@class='btn book-bt-n ng-scope']"));
		int i=0, j=0;
		for (WebElement flightNumber : flightsNumber) {
			i++;
			if (flightNumber.getText().equals("UK-981"))
				break;
		}
		
		for (WebElement book : booknow) {
			j++;
			if (j==i)
				book.click();
		}
		
		String BookedFlight = driver.findElement(By.xpath("//div[@class='fli1']/div/div[2]/span[2]")).getText();
		Assert.assertEquals(BookedFlight, "UK-9811" , "Vimlesh Correct Flight not Booked");
	}

	@SuppressWarnings({ "deprecation" })
	@Test(enabled = true)
	public static void MMTSelectFlight() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@class='commonModal__close']")).click();
		
		driver.findElement(By.xpath("//label[@for='fromCity']/input")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Mumbai");
		
		List<WebElement> fromLocations = driver.findElements(By.xpath("//span[@class='makeFlex flexOne spaceBetween appendRight10']/span"));
		for(WebElement fromLocation: fromLocations ) {
			if(fromLocation.getText().contains("Mumbai")) {
				fromLocation.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//label[@for='toCity']/input")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Lucknow");
		
		List<WebElement> toLocations = driver.findElements(By.xpath("//span[@class='makeFlex flexOne spaceBetween appendRight10']/span"));
		for(WebElement toLocation: toLocations ) {
			if(toLocation.getText().contains("Lucknow")) {
				toLocation.click();
				break;
			}
		}
		
		List<WebElement> Departure = driver.findElements(By.xpath("//div[@class='dateInnerCell']/p"));
		for(WebElement date: Departure ) {
			if(date.getText().contains("26")) {
				date.click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@class='makeFlex vrtlCenter ']/a")).click();
	}
}