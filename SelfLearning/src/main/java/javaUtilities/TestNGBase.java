package javaUtilities;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestNGBase {
	
	@BeforeTest
	public void setup() throws IOException{
		System.out.println("Browser is launched ");
	}
	
	
	@AfterTest
	public void teardown() {
		System.out.println("Browser is Closed ");

	}
}
