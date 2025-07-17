package com.automation.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/ui")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, 
                       value = "pretty," +
                               "html:target/cucumber-reports/ui," +
                               "json:target/cucumber-reports/ui-tests.json," +
                               "junit:target/cucumber-reports/ui-tests.xml")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.automation.steps.ui")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@ui")
public class UiTestRunner {
    // This class will run only UI tests
}
