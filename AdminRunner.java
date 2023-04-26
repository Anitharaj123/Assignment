package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/feature/Admin.feature",glue="stepsdef",
monochrome=true,publish=true)
public class AdminRunner extends AbstractTestNGCucumberTests  {
	

}


