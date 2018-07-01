package api.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(

        plugin={"pretty:target/cucumber-pretty.txt",
                "html:target/html-report",
                "json:target/json/json-report.json"
        },
        tags = {"@James"},
        features = {""},
        glue = {""},
        dryRun = true


)

public class CukesRunner {
}
