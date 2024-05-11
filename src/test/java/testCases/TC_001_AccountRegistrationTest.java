package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
		
		@Test(groups={"Regression","Master"})
		public void verify_account_registration()
		{
			logger.info("Starting TC001_AccountRegistrationTest");
			
			logger.debug("This is a debug log message");
			
			try
			{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			
			hp.clickRegister();
			logger.info("Clicked on Register Link");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			logger.info("Providing customer details");
			//regpage.setFirstName(randomeString().toUpperCase());
			regpage.setFirstName(camelcaseString());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");
			regpage.setTelephone(randomeNumber());
			
			String password=randomAlphaNumeric();
			
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			logger.info("Validating expected messaage");
			
			String confmsg=regpage.getConfirmationMsg();
			/*if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}*/
				
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
			
			logger.info("Test passed");
			}
			catch(Exception e)
			{
				logger.error("Test failed: " + e.getMessage());
				Assert.fail("Test failed: " + e.getMessage());
			}
			finally 
			{
				logger.info("Finished TC001_AccountRegistrationTest");
			}
		}
}
