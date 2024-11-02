package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	public DashboardPage(WebDriver driver){
		this.driver = driver;
	}
	String searchLocater = "//input[@placeholder='Search']";
	String leaveLocater = "//ul[@class='oxd-main-menu']/li[3]//a/span";
	
	@SuppressWarnings("deprecation")
	public void SearchLeave() {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath(searchLocater)).click();
		driver.findElement(By.xpath(searchLocater)).sendKeys("Leave");
	}
	
	@SuppressWarnings("deprecation")
	public void OpenLeave() {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath(leaveLocater)).click();
		
	}

}
