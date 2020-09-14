package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DealsPage extends TestBase
{
	@FindBy(xpath="//div[@class='value']")
	WebElement NoOfDeals;

	DealsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String getNoOfDeals()
	{
		return NoOfDeals.getText();
	}
}
