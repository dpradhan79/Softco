package com.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.config.IConstants;
import com.utilities.ReusableLibs;

public abstract class PageTemplate {
	private static final Logger LOG = Logger.getLogger(PageTemplate.class);
	protected WebDriver driver = null;
	protected ReusableLibs reUsableLib = null;
	
	protected PageTemplate(WebDriver webDriver)
	{
		this.driver = webDriver;
		this.reUsableLib = new ReusableLibs();
	}
	
	protected void SendKeys(By byLocator, String text) throws Exception
	{
		try
		{
			this.waitUntilElementIsClickable(byLocator);
			this.driver.findElement(byLocator).sendKeys(text);
			LOG.info(String.format("SendKeys Successful - (By - %s, text - %s)", byLocator, text));
		}
		catch(Exception ex)
		{
			LOG.error(String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()));
			throw ex;
		}
		
	}
	
	protected void Click(By byLocator) throws Exception
	{
		try
		{
			this.waitUntilElementIsClickable(byLocator);
			this.driver.findElement(byLocator).click();;
			LOG.info(String.format("Click Successful - (By - %s)", byLocator));
		}
		catch(Exception ex)
		{
			LOG.error(String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()));
			throw ex;
		}
		
	}

	protected String getAttribute(By byLocator, String attribute) throws Exception
	{
		String attributeValue = null;
		try
		{
			this.waitUntilElementIsClickable(byLocator);
			attributeValue = this.driver.findElement(byLocator).getAttribute(attribute);
			LOG.info(String.format("Click Successful - (By - %s)", byLocator));
		}
		catch(Exception ex)
		{
			LOG.error(String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()));
			throw ex;
		}
		return attributeValue;
		
	}
	
	public void logout()
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			String byLoginButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "LoginButton");
			//Click on logout
			String logoutButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "LogoutButton");
			
			//Wait For Logout Button To Be Clickable, as click throwing staleelementexception.
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutButton)));
			
			this.driver.findElement(By.xpath(logoutButton)).click();
			LOG.info(String.format("Click Successful - (By - %s)", logoutButton));
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(byLoginButton)));
			LOG.info("Application logged out successfully");
		}
		catch(Exception ex)
		{
			LOG.error(String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()));
			throw ex;
		}
	}
	
	protected boolean waitUntilElementIsClickable(By byLocator)
	{
		boolean isSuccess = false;
		try
		{
		String timeout = reUsableLib.getConfigProperty("PageLoadTimeOutInSecs");
		WebDriverWait wait = new WebDriverWait(this.driver,Long.valueOf(timeout).longValue());
		wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		LOG.info(String.format("Element clickable - (By - %s)", byLocator));
		isSuccess = true;
		}
		catch(Exception ex)
		{
			isSuccess = false;
			LOG.error(String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()));
			throw ex;
		}
		return isSuccess;
	}
	
	public boolean isElementDisplayed(By byLocator)
	{
		boolean isSuccess = false;
		try
		{
			//validate element is displayed or not
			Assert.assertEquals(driver.findElements(byLocator).size(), 1);
			LOG.info(String.format("Element displayed - (By - %s)", byLocator));
			isSuccess = true;
		}
		catch(Exception ex)
		{
			LOG.info(String.format("Element not displayed - (By - %s)", byLocator));
			isSuccess = false;
		}
		catch(AssertionError ae)
		{
			LOG.info(String.format("Element not displayed - (By - %s)", byLocator));
			isSuccess = false;
		}
		return isSuccess;
	}
	
	public void implicitwait(int sec)
	{
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
