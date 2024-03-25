package com.example.Webbutiken_team2;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "pretty"
        },
        features = "src/test/java/com/example/Webbutiken_team2/resources/features")


public class CukesRunnerTest {
}
