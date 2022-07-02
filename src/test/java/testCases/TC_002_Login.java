package testCases;
//login
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
	@Test(groups= {"sanity","master"})
	public void test_Login()
	{
		logger.info(" Starting TC_002_Login ");
		try
		{
			driver.get(rb.getString("appURL"));
			driver.manage().window().maximize();
			logger.info("Home Page Displayed ");
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			hp.clickLogin();
			logger.info("Clicked on Login ");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			//lp.setEmail(rb.getString("rrr@gmail.com"));//to intentionaly fail the test
			logger.info("Provided Email ");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password ");
			
			lp.clickLogin();
			logger.info("Clicked on Login");
			
			boolean targetpage=lp.isMyAccountPageExists(); 
			
			if(targetpage)
			{
				logger.info("Login Success ");
				Assert.assertTrue(true);				
			}
			else
			{
				logger.error("Login Failed ");
				captureScreen(driver, "test_Login");				
			}			
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();			
		}
		
		logger.info(" Finished TC_002_Login ");
	}

}
