package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"D:\\MyAutomation\\OrangeHrmBBD\\src\\test\\resources\\feature\\"},
		glue = {"steps"}, 
		tags = ("@Reg or @Smoke"),
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:D:\\MyAutomation\\OrangeHrmBBD\\test-output\\report.html"}	
				)
public class TesgNGTestRunner extends AbstractTestNGCucumberTests {
}