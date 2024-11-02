package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIM {
	
	WebDriver driver;
	public PIM(WebDriver driver){
		this.driver = driver;
	}

	By GotoPIM = new By.ByXPath("//ul[@class='oxd-main-menu']/li[2]//a/span");
	By AddEmployee = new By.ByXPath("//nav[@class='oxd-topbar-body-nav']/ul/li[3]");
	By firstName = new By.ByXPath("//input[@name='firstName']");
	By middleName = new By.ByXPath("//input[@name='middleName']");
	By lastName = new By.ByXPath("//input[@name='lastName']");
	By enableCreateLogin = new By.ByXPath("//div[@class='oxd-switch-wrapper']");
	
	
	
	//input[@class='oxd-input oxd-input--active' and @autocomplete='off']
	
	@SuppressWarnings("deprecation")
	public void GotoPIM() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(GotoPIM).click();
	}
	
	public void AddEmployee() {
		driver.findElement(AddEmployee).click();
		
	}
	public void firstName() {
		driver.findElement(firstName).sendKeys("Vimlesh");
		
	}
	public void middleName() {
		driver.findElement(middleName).sendKeys("");
		
	}
	public void lastName() {
		driver.findElement(lastName).sendKeys("Kumar");	
	}
	public void enableCreateLogin() {
		driver.findElement(enableCreateLogin).click();	
	}
	
	
}
