package com.automation.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, 
                       value = "pretty," +
                               "html:target/cucumber-reports/all-report.html," +
                               "json:target/cucumber-reports/all-tests.json," +
                               "junit:target/cucumber-reports/all-tests.xml")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.automation.steps")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "not @ignore")
public class TestRunner {
    // This class will run all cucumber tests
}
