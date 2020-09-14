package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase
{

	@FindBy(name="email")
	WebElement email;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//div[@id='ui']//div[text()='Login']")
	WebElement LoginBtn;

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle()
	{
		return driver.getTitle();
	}

	public HomePage login(String Username,String Password)
	{
		email.sendKeys(Username);
		password.sendKeys(Password);
		LoginBtn.click();
		return new HomePage();
	}

	public String verifyLoginPage()
	{
		return LoginBtn.getText();
	}
}
