package Fitness;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (

                features = "src/test/Features",
                glue = "Fitness",
                plugin = {"pretty", "html:target/cucumber-report.html"}
        )

class ProgramManagementTest
{


}