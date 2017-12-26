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
			
			this.addButtonVisibility(isAddButtonVisisble);
			this.emailTemplateValidation();
			this.validateAllFieldsAreDisabledInHeader();
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
	
	private boolean addButtonVisibility(String isAddButtonVisisble)
	{
		boolean isSuccess = false;
		try
		{
			String addButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "AddButton");
			String searchCriteria = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "searchCriteriaButton");
			this.waitUntilElementIsClickable(By.xpath(searchCriteria));
			boolean addButtonStatus = this.isElementDisplayed(By.xpath(addButton));
			if(isAddButtonVisisble.equalsIgnoreCase("yes"))
			{
				if(addButtonStatus)
					LOG.info("Add button Displayed");
				else
					LOG.error("Add button not displayed");
			}
			else if(isAddButtonVisisble.equalsIgnoreCase("No"))
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
	
	private boolean emailTemplateValidation() throws Exception
	{
		boolean isSuccess = false;
		try
		{
			String elipses = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ElipsesMenu");
			String emailButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "EmailButton");
			String emailPopUpCloseIcon = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "EmailPopupCloseIcon");
			
			this.waitUntilElementIsClickable(By.xpath(elipses));
			this.Click(By.xpath(elipses));
			this.waitUntilElementIsClickable(By.xpath(emailButton));
			this.Click(By.xpath(emailButton));
			this.implicitwait(2);
			this.waitUntilElementIsClickable(By.xpath(emailPopUpCloseIcon));
			this.Click(By.xpath(emailPopUpCloseIcon));
			this.implicitwait(2);
		}
		catch(Exception ex)
		{
			isSuccess = false;
			LOG.error(String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()));
			throw ex;
		}
		return isSuccess;
	}
	
	public boolean validateAllFieldsAreDisabledInHeader()
	{
		boolean isSuccess = false;
		try
		{
			String headerInputFields = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "Header_InputFields");
			String headerInputLables = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "Header_inputFieldNames");
			
		//Store all elements into input fields
    	List<WebElement> inputFields = driver.findElements(By.xpath(headerInputFields));
    	List<WebElement> inputFieldLables = driver.findElements(By.xpath(headerInputLables));
    	
    	//Print total elements
    	LOG.info("Total elements displayed are " + inputFields.size());
    	
    	//iterate and validate all are disabled or not
    	for(int i=1;i<inputFields.size();i++)
    	{
    		if((inputFields.get(i).getAttribute("readonly")).equalsIgnoreCase("true"))
    		{
    			LOG.info("Input field " + inputFieldLables.get(i) + " is diabled");
    		}
    		else
    		{
    			LOG.error("Input field " + inputFieldLables.get(i) + " is not diabled");
    		}
    		isSuccess = true;
    	}
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
