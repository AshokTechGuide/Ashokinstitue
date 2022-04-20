package com.cucumberFramework.testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(features = "C:\\Projects\\Cucumber-BDD-Automation-Framework-master\\src\\test\\resources\\features\\login\\OrrangeHRM.feature", glue = { "com/cucumberFramework/stepdefinitions" }, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
		"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt" },
tags="@tag1",
		monochrome = true, dryRun = false)
public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	   
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs cucmber Features", dataProvider = "features")
public void feature(CucumberFeatureWrapper cucumberFeature) {
	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
}
// chromedriver
@DataProvider
public Object[][] features() {
	return testNGCucumberRunner.provideFeatures();
}

@AfterClass(alwaysRun = true)
public void testDownClass() {
	testNGCucumberRunner.finish();
}

}
