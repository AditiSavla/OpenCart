package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_007_ProductDisplayTest extends BaseClass{
	
	@Test(groups= {"Master"})
	public void verify_productdisplay() {
		
		logger.info("Starting TC_007_ProductDisplayTest");

		try {
			
			HomePage hm=new HomePage(driver);
			
			hm.enterProductName("mac");
			
			hm.clickSearch();
			
			ProductDisplayPage pd = new ProductDisplayPage(driver);
			pd.clickMacBook();
			
			Assert.assertEquals(pd.checkConfPrName(),true);
			Assert.assertEquals(pd.checkConfBrName(),true);
			Assert.assertEquals(pd.checkConfPrCode(),true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
