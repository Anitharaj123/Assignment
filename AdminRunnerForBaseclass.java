package runner;


import io.cucumber.testng.CucumberOptions;
import steps.AdminBaseClass;

@CucumberOptions(features="src/test/java/feature/Admin.feature",glue="stepsdef",
monochrome=true,publish=true)
public class AdminRunnerForBaseclass extends AdminBaseClass  {
	

}
