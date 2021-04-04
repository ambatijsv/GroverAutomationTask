package com.grover.imdb;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "res/features", glue = "com.grover.imdb.steps", plugin = { "pretty",
		"json:target/cucumber-jvm-report/cucumber.json" }, monochrome = true, tags = {"@imdb"})
public class TestRunner {

}
