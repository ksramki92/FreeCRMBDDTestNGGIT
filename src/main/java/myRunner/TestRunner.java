package myRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions
( features= "C:\\Users\\Ramki\\workspace\\FreeCRMBDDTestNG\\src\\main\\java\\features\\Login.feature",
glue= {"stepDefinitions"},
plugin={"pretty","html:target/html/cucumber.html","json:target/json/cucumber.json",
"junit:target/xml/cucumber.xml"},
monochrome=true,
dryRun=false)

public class TestRunner
{
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun=true)
	public void setUpClass()
	{
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups="cucumber", description="Runs cucumber feature", dataProvider="features")
	public void feature(CucumberFeatureWrapper cucumberfeature)
	{
		testNGCucumberRunner.runCucumber(cucumberfeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features()
	{
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		testNGCucumberRunner.finish();
	}
}
