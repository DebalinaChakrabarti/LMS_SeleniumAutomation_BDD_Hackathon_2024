package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;


@io.cucumber.testng.CucumberOptions(
		features= {"src/test/resources/Features"},
				
		glue= {"StepDefinitions","Hooks"},

		plugin= {"pretty","html:target/cucumber-reports/reports.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"json:target/cucumber-reports/cucumber.json",
				"junit:target/cucumber-reports/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt"},
				publish=true,
				tags="not @skip"
)

public class MyTestRunner extends AbstractTestNGCucumberTests{

	
	
	
}
