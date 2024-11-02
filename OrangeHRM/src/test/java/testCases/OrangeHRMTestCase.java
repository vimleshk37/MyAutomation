package testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTestRemote;
import pages.LoginPage;
import pages.PIM;
import utilities.HRMDataProvider;
@Listeners(listeners.ListenerTest.class)
public class OrangeHRMTestCase extends BaseTestRemote {
	@Test(dataProvider = "credentials", groups = { "login",
			"smoke" } ,enabled = true, dataProviderClass = HRMDataProvider.class)
	public void LoginToHRM(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.HrmLogin(username, password);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		if (actualUrl.equals(expectedUrl))
			System.out.println("Login is successful :)");
		else
			System.out.println("Login is not successful :(");
		Assert.assertEquals(expectedUrl, actualUrl);
	}


	@SuppressWarnings("deprecation")
	@Test(groups = { "smoke",
			"regression" },dependsOnMethods = "LoginToHRM" , enabled = true)
	public void AddEmp() {;
		PIM pim = new PIM(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		pim.GotoPIM();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		pim.AddEmployee();
		pim.firstName("Vimlesh");
		pim.middleName("");
		pim.lastName("Kumar");
		pim.enableCreateLogin();
		

		
	}
}