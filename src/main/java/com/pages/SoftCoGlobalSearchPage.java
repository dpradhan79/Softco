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
	private static final Logger LOG = Logger.getLogger(SoftCoGlobalSearchPage.class);
	public SoftCoGlobalSearchPage(WebDriver webDriver) {
		super(webDriver);
		
	}
	public boolean validateSearchForDocument(String isAddButtonVisisble) throws Exception
	{
		boolean isSuccess = false;
		try
		{
			String searchButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "SearchForDoc_SearchButton");
			String searchCriteriaButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "searchCriteriaButton");
			String recordsDisplayed = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "rowsInResultsTable");
			String invoice = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "Invoices");
			homePageObj.navigateToSearchForADocument();
			this.waitUntilElementIsClickable(By.xpath(searchButton));
			this.Click(By.xpath(searchButton));
			this.waitUntilElementIsClickable(By.xpath(searchCriteriaButton));
			
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
			isSuccess = true;
			
			invoicePageObj.addButtonVisibility(isAddButtonVisisble);
			invoicePageObj.emailTemplateValidation();
			invoicePageObj.validateAllFieldsInHeader();
			this.Click(By.xpath(invoice));
		}
		catch(Exception ex)
		{
			isSuccess = false;
			LOG.error(String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()));
			throw ex;
		}
		return isSuccess;
	}
	
	public boolean validateMissingClient(String isAddButtonVisisble) throws Exception
	{
		boolean isSuccess = false;
		try
		{
			String recordsDisplayed = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "rowsInResultsTable");
			homePageObj.navigateToMissingClient();
			
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
			isSuccess = true;
			
			invoicePageObj.addButtonVisibility(isAddButtonVisisble);
			invoicePageObj.emailTemplateValidation();
			invoicePageObj.validateAllFieldsInHeader();
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
