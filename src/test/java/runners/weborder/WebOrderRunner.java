package runners.weborder;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "",//this is path for feature files
        glue = "", // for step definitions
        dryRun = true
)
public class WebOrderRunner {
    //Runner class is the way to run your all feature files from here
    //RunWith annotation comes Junit and it executes the feature file steps



}
