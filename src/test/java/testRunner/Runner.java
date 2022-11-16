package testRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/resources/feature/DBtoExcelComparison.feature", 
			glue={"stepDefinitions"}, 
			format= {"pretty","html:target/test-outout"},
			monochrome = true,
			dryRun = false			
			)

public class Runner {
		
}
