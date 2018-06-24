package api.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		tags = "@n, @p", 
		features = "src/test/java/api/features/",
		glue = "api/step_definitions",
		dryRun = true
		
	)



public class cukesrunner {

}
