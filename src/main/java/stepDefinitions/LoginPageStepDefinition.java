package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageStepDefinition extends TestBase
{
	LoginPage login;
	HomePage homepage;
	@Given("^User is already on login page$")
	public void User_is_already_on_login_page()
	{
		initialization();
	}

	@Then("^Title of the page is Free CRM$")
	public void Title_of_the_page_is_Free_CRM()
	{
		login=new LoginPage();
		String title=login.getPageTitle();
		Assert.assertEquals(title,"Cogmento CRM");
	}

	@Then("^User enters \"(.*)\" and \"(.*)\"$")
	public void User_enters_username_and_password(String username,String password)
	{
		homepage=login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^User is on home page$")
	public void User_is_on_home_page()
	{
		String title=homepage.getPageTitle();
		Assert.assertEquals(title,"Cogmento CRM");
	}

	@Then("^User verifies the username$")
	public void User_verifies_the_username()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String username=homepage.checkUserName();
		Assert.assertEquals("Ramki K", username);
	}

	@Then("^User logs out$")
	public void User_logs_out()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homepage.logout();
		Assert.assertEquals(login.verifyLoginPage(), "Login");
		driver.quit();
	}
}
