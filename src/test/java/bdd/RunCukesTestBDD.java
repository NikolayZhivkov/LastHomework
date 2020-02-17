package bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(plugin = {"progress", "html:target/cucumber-html-report"},
        features = "src/test/resources",
        glue = "java.bdd",
        tags = {"@dev", "~@bug"})

public class RunCukesTestBDD extends AbstractTestNGCucumberTests {
}
