package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.config.IConstants;

public class SoftCoGlobalSearchPage extends PageTemplate {
	SoftCoHomePage homePageObj = new SoftCoHomePage(this.driver);
	private static final Logger LOG = Logger.getLogger(SoftCoGlobalSearchPage.class);
	public SoftCoGlobalSearchPage(WebDriver webDriver) {
		super(webDriver);
		
	}
	public boolean validateSearchForADocument() throws Exception
	{
		boolean isSuccess = false;
		try
		{
			homePageObj.navigateToSearchForADocument();
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
}
