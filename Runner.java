package Run;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


public class Runner {

	@CucumberOptions(
	    features = "src/test/java/Cucumber/simple.feature",
	    glue = "Step",
	    dryRun=false,
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports.html"
	    },
	    monochrome = true
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}

}
