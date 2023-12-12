package hifresh;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("hifresh")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")

// use this if your cucumber test classes are not in the same package as the CucumberRunner class
// supports a , separated list of values
// can also be specified in junit-platform.properties
// @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "be")
public class RunCucumberTest
{
}

