package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebPageMethods {
	public void SelectFropDown(WebElement element, String str) {
		
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(str);
		
	}
	
	public void BootStrepSelectFropDown(List<WebElement> opt, String str) {
		
        System.out.println("Total Elements are " +opt.size());
        for(WebElement el : opt) {
       	 System.out.println("Elements are " + el.getText());
       	 if(el.getText().equals(str)) {
       		el.click();
       		break;
       	}
      }
	}
	
	public void DropdownShortingCheck(List<WebElement> opt){
        ArrayList<String> OrignalArray = new ArrayList<String>();
        ArrayList<String> tempArray = new ArrayList<String>();
        for(WebElement options:opt) {
        	OrignalArray.add(options.getText());
        	tempArray.add(options.getText());
        }
        Collections.sort(tempArray);;
        if(OrignalArray.equals(tempArray))
        	System.out.println("Dropdown is shorted");
        else
        	System.out.println("Dropdown is Unshorted");	
	}
	
	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	} 

}
