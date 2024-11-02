package javaLearning;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javaUtilities.TestNGBase;
import javaUtilities.TestNGDataProvider;

public class TestNGCode extends TestNGBase  {
	@Parameters({"User"})
	@Test (groups="login" , enabled=true, dataProvider="create", dataProviderClass = TestNGDataProvider.class)
	public static void newloginTest(String email, String Pass, String Otp) {
		System.out.println("Email is: " + email + " Password is: " +Pass + " OTP is: " +Otp);
	}
	
	@Test (groups ={"smoke", "regression", "login"}, dependsOnMethods = "newloginTest", enabled=true, dataProvider="create", dataProviderClass = TestNGDataProvider.class)
	public static void loginTest(String email, String Pass, String User) {
		System.out.println("Email is: " + email +" User Name is: " + User + " Password is: " +Pass);
	}
}