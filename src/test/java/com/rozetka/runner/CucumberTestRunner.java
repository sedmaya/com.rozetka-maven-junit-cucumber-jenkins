package com.rozetka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/rozetka-reports",
                "json:target/rozetka-reports/RozetkaTests.json",
                "junit:target/rozetka-reports/RozetkaTests.xml"},
        monochrome = true
        ,features = "classpath:com.rozetka.features"
        ,glue = {"com.rozetka"}
        ,tags = {"@NegativeTest"}
)
public class CucumberTestRunner {

}
