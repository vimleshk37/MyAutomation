package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.PIM;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;

public class HrmStep {

	public static WebDriver driver;
	@BeforeAll
	public static void setup() {
		driver = new ChromeDriver();
		System.out.println(" Browser is launched");
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@AfterAll
	public static void teardown() {
		// driver.quit();
		System.out.println("Browser is Closed ");
	}

	@Given("User is navigating to OrangeHRM Login Page")
	public void user_is_navigating_to_orange_hrm_login_page() throws IOException {
		System.out.println("Browser is launched and HRM Login page is open now");
	}

	LoginPage loginpage = new LoginPage(driver);

	@When("^User need to enter username as (.*) and password as (.*)")
	public void user_need_to_enter_username_as_and_password_as(String user, String pass) throws InterruptedException {
		loginpage.SendUser(user);
		loginpage.SendPass(pass);
	}

	@And("Click on Submit Button")
	public void Click_on_Submit_Button() {
		loginpage.SubmitToLogin();
	}

	@Then("Verify User is successfully navigated to the OrangeHRM Dashboard")
	public void user_is_successfully_navigated_to_the_orange_hrm_mail_box() throws InterruptedException {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		if (actualUrl.equals(expectedUrl))
			System.out.println("Login is successful :)");
		else
			System.out.println("Login is not successful :(");
		Assert.assertEquals(expectedUrl, actualUrl);
	}

	PIM pim = new PIM(driver);

	@Given("Navigate to PIM Page")
	public void Navigate_to_PIM_Page() throws InterruptedException {
		pim.GotoPIM();
	}

	@When("Open Add Employee Tab")
	public void Open_Add_Employee_Tab() throws InterruptedException {
		pim.AddEmployee();
	}

	@And("Fill Employee Information")
	public void Fill_Employee_Information() throws InterruptedException {
		pim.firstName();
		pim.middleName();
		pim.lastName();
		pim.enableCreateLogin();
	}

	@Then("Verify Employee added successfully navigated")
	public void Verify_Employee_added_successfully_navigated() throws InterruptedException {
		System.out.println("Employee added successfully :)");
	}
}