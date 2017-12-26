package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
			this.driver.findElement(byLocator).click();;
			LOG.info(String.format("Click Successful - (By - %s)", byLocator));
		}
		catch(Exception ex)
		{
			LOG.error(String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()));
			throw ex;
		}
		
	}

}
