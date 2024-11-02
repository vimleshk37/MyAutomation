package base;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import apiTestCases.RL3PLApi;

public class BaseTest {
	protected static String authorization = "";

	@BeforeClass
	public void getAuthorization() throws IOException {
		authorization = "Bearer " + RL3PLApi.Rl3PlTokenAPI();
	}

	@AfterClass
	public void teardown() {
		// driver.quit();
		System.out.println("Browser is closed");
	}

}
