package dev.grbackend;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("dev/grbackend")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "dev.grbackend")
@ConfigurationParameter(key = PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = PLUGIN_PUBLISH_TOKEN_PROPERTY_NAME, value = "feacc5a6-2fb6-4552-8a66-6e79cb94f417")
@CucumberContextConfiguration
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RunCucumberTest {
}
