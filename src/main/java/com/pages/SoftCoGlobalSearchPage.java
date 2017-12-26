package com.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.config.IConstants;

public class SoftCoGlobalSearchPage extends PageTemplate {
	SoftCoHomePage homePageObj = new SoftCoHomePage(this.driver);
	private static final Logger LOG = Logger.getLogger(SoftCoGlobalSearchPage.class);
	public SoftCoGlobalSearchPage(WebDriver webDriver) {
		super(webDriver);
		
	}
	public boolean validateSearchForDocument(String AddButtonStatus) throws Exception
	{
		boolean isSuccess = false;
		try
		{
			String searchButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "SearchForDoc_SearchButton");
			String searchCriteriaButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "searchCriteriaButton");
			String recordsDisplayed = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "rowsInResultsTable");
			homePageObj.navigateToSearchForADocument();
			this.waitUntilElementIsClickable(By.xpath(searchButton));
			this.Click(By.xpath(searchButton));
			this.waitUntilElementIsClickable(By.xpath(searchCriteriaButton));
			
			//Get all the records displayed in results table
			List<WebElement> results = this.driver.findElements(By.xpath(recordsDisplayed));
			LOG.info("Store all elements to obj "+results);
			//Check results count
			int resultsCount = results.size();
			LOG.info("Total elements displayed are "+resultsCount);
			
			//validate results count and click on first record if records displayed
			if(resultsCount==0)
				LOG.info("No records displayed in search results");
			else
			//click on the first record displayed
				results.get(1).click();
			LOG.info("clicked on first available record");
			isSuccess = true;
			
			this.addButtonVisibility(AddButtonStatus);
		}
		catch(Exception ex)
		{
			isSuccess = false;
			LOG.error(String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()));
			throw ex;
		}
		return isSuccess;
	}
	
	private boolean addButtonVisibility(String status)
	{
		boolean isSuccess = false;
		try
		{
			String addButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "AddButton");
			String searchCriteria = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "searchCriteriaButton");
			this.waitUntilElementIsClickable(By.xpath(searchCriteria));
			boolean addButtonStatus = this.isElementDisplayed(By.xpath(addButton));
			if(status.equalsIgnoreCase("yes"))
			{
				if(addButtonStatus)
					LOG.info("Add button Displayed");
				else
					LOG.error("Add button not displayed");
			}
			else if(status.equalsIgnoreCase("No"))
			{
				if(addButtonStatus)
					LOG.error("Add button Displayed");
				else
					LOG.info("Add button not displayed");
			}
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
