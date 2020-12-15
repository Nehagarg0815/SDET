package JobBoardProject;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(
	
    features = "Features_JobBoard",
	glue = {"stepDefinitions_JobBoard"},
	tags = "@createuser or @jobapply or @jobpost or @examplepost",
	plugin = { "pretty", "html:target/cucumber-reports/reports" },
	monochrome = true
)

    public class TestRunner{
    	
    }