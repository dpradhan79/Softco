package com.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.config.IConstants;

public class SoftCoGlobalSearchPage extends PageTemplate {
	SoftCoInvoicePage invoicePageObj = new SoftCoInvoicePage(this.driver);
	SoftCoHomePage homePageObj = new SoftCoHomePage(this.driver);
	
	//Locators
	private String recordsDisplayed = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "rowsInResultsTable");
	private String searchButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "SearchForDoc_SearchButton");
	private String searchCriteriaButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "searchCriteriaButton");	
	private String invoice = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "Invoices");
	
	private static final Logger LOG = Logger.getLogger(SoftCoGlobalSearchPage.class);
	public SoftCoGlobalSearchPage(WebDriver webDriver) {
		super(webDriver);
		
	}
	public boolean validateSearchForDocument(String isEditable) throws Exception
	{
		boolean isSuccess = false;
		try
		{		
			//Navigate to search for a document page
			homePageObj.navigateToSearchForADocument();
			
			//wait until search button is clickable and click on search button
			this.waitUntilElementIsClickable(By.xpath(searchButton));
			this.Click(By.xpath(searchButton));
			
			//wait until search criteria button enables so that search results displayed completely
			this.waitUntilElementIsClickable(By.xpath(searchCriteriaButton));
			
			//click on first available record in search results
			this.clickOnFirstAvailableRecordInSearchResults();
						
			invoicePageObj.validateInvoicePage(isEditable);
			this.Click(By.xpath(invoice));
			invoicePageObj.acceptUnSavedChangesPopUp();
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
	
	public boolean validateMissingClient(String isEditable) throws Exception
	{
		boolean isSuccess = false;
		try
		{
			homePageObj.navigateToMissingClient();
			
			this.clickOnFirstAvailableRecordInSearchResults();
			
			invoicePageObj.validateInvoicePage(isEditable);
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
	
	private boolean clickOnFirstAvailableRecordInSearchResults()
	{
		boolean isSuccess = false;
	try
	{	
		//Get all the records displayed in results table
		List<WebElement> results = this.driver.findElements(By.xpath(recordsDisplayed));
		LOG.info("Store all elements to obj " + results);
		//Check results count
		int resultsCount = results.size();
		LOG.info("Total elements displayed are " + resultsCount);
		
		//validate results count and click on first record if records displayed
		if(resultsCount == 0)
			LOG.info("No records displayed in search results");
		else
		//click on the first record displayed
			results.get(1).click();
		LOG.info("clicked on first available record");
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
