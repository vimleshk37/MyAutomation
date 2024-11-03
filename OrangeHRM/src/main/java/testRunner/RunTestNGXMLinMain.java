package testRunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RunTestNGXMLinMain {
	public static void main(String str[]) {
		TestNG runner = new TestNG();
		String path = System.getProperty("user.dir")+"/TestRunner/testng.xml";
		List <String> testngpath = new ArrayList<String>();
		testngpath.add(path);
		
		runner.setTestSuites(testngpath);
		runner.run();
		
	}

}
