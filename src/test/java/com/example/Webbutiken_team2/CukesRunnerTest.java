package com.example.Webbutiken_team2;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Webbutiken_team2")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class CukesRunnerTest {
}
