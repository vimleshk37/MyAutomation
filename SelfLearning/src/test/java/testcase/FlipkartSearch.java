package testcase;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class FlipkartSearch extends BaseTest {
	
	@Test
	public static void SearchProduct() throws InterruptedException, IOException {
		//https://www.flipkart.com/"		
        WebElement search = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        search.sendKeys("Samsung");
        Thread.sleep(1000);
        String text;
        do {
        	search.sendKeys(Keys.ARROW_DOWN);
        	text = search.getAttribute("value");
        	if(text.equals("samsung mobiles")) {
        	search.sendKeys(Keys.ENTER);
        	break;
        	}
        }while(!text.isEmpty());

        String paparenthandle = driver.getWindowHandle();
        System.out.println("Handle Windows: " +paparenthandle);
        
        List<WebElement> product = driver.findElements(By.xpath("//*[@class=\"KzDlHZ\"]"));
        for(WebElement prod:product) {
        	if(prod.getText().equals("SAMSUNG Galaxy S23 FE (Graphite, 128 GB)"))
        		prod.click();
        }
        
        Thread.sleep(500);
        //driver.findElement(By.xpath("//div[contains(text(),'SAMSUNG Galaxy S23 FE (Graphite, 128 GB)')]")).click();
        Set<String> handles = driver.getWindowHandles();
        for(String actual:handles) {
        if(!actual.equals(paparenthandle)) {
        	System.out.println("NewHandle Tab: " +actual);
        	driver.switchTo().window(actual);
        	//Go to Buy Now
        	//driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ _3Yl67G _7Pd1Fp']")).click();
        	//Add to Cart
        	driver.findElement(By.xpath("//button[@class=\"QqFHMw vslbG+ In9uk2\"]")).click();
        			}
        		}
        Thread.sleep(5000);
	}
}