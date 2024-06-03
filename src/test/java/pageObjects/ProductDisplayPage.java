package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage{
	
	public ProductDisplayPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//img[@title='MacBook']")
    WebElement lnkMacBook;
	

	@FindBy(xpath = "//h1[normalize-space()='MacBook']")
	WebElement cnfPrName;
	
	@FindBy(xpath = "//a[normalize-space()='Apple']")
	WebElement cnfBrName;
	
	@FindBy(xpath = "//li[normalize-space()='Product Code: Product 16']")
	WebElement cnfPrCode;
	
	public void clickMacBook()
	{
		lnkMacBook.click();
	}
	
	public boolean checkConfPrName()
	{
		try
		{
		return cnfPrName.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean checkConfBrName()
	{
		try
		{
		return cnfBrName.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean checkConfPrCode()
	{
		try
		{
		return cnfPrCode.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
