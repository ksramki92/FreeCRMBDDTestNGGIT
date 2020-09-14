package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//span[@class='user-display']")
	WebElement username;

	@FindBy(xpath="//i[@class='settings icon']")
	WebElement logoutLink;

	@FindBy(xpath="//span[text()='Log Out']")
	WebElement logoutBtn;

	HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle()
	{
		return driver.getTitle();
	}

	public String checkUserName()
	{
		return username.getText();
	}

	public void logout()
	{
		logoutLink.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		logoutBtn.click();
	}

}
