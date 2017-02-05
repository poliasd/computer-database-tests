package com.polina.ui.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty",
                "json:build/Cucumber.json",
                "html:build/cucumber-html-report"      
       }, 
       features = "src/test/resources",
       glue = "com.polina.ui.tests.steps", 
       tags = "@Regression"
)

public class TestRun {

}
