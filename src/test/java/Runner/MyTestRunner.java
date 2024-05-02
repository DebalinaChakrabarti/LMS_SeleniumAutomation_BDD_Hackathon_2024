package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;


@io.cucumber.testng.CucumberOptions(
		features= {"src/test/resources/Features/01_login.feature"
				,"src/test/resources/Features/02_01_manageProgram.feature"
				,"src/test/resources/Features/02_02_addNewProgram.feature"
				,"src/test/resources/Features/02_03_editProgramDetails.feature"
				},
		glue= {"StepDefinitions","Hooks"},

		plugin= {"pretty","html:target/cucumber-reports/reports.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"json:target/cucumber-reports/cucumber.json",
				"junit:target/cucumber-reports/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt"},
				publish=true,
				tags=""
)

public class MyTestRunner extends AbstractTestNGCucumberTests{

	
	
	
}
