package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.config.IConstants;

public class SoftCoInvoicePage extends PageTemplate {
	SoftCoHomePage homePageObj = new SoftCoHomePage(this.driver);
	private static final Logger LOG = Logger.getLogger(SoftCoInvoicePage.class);
	public SoftCoInvoicePage(WebDriver webDriver) {
		super(webDriver);
		
	}	
	
	private boolean addButtonVisibility(String isEditable)
	{
		boolean isSuccess = false;
		try
		{
			String addButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "AddButton");
			String ElipsesMenu = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ElipsesMenu");
			this.waitUntilElementIsClickable(By.xpath(ElipsesMenu));
			boolean addButtonStatus = this.isElementDisplayed(By.xpath(addButton));
			if(isEditable.equalsIgnoreCase("yes"))
			{
				if(addButtonStatus)
					LOG.info("Add button Displayed");
				else
					LOG.error("Add button not displayed");
			}
			else if(isEditable.equalsIgnoreCase("No"))
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
	
	private boolean validateAllFieldsInHeader()
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
    		String attribute = inputFields.get(i).getAttribute("readonly");
    		LOG.info("Read Only Attribute value of " + inputFieldLables.get(i).getText() + " is " + attribute);
    		try
    		{
    			Assert.assertNotNull(attribute);
    			LOG.info("Input field " + inputFieldLables.get(i).getText() + " is diabled");
    		}
    		catch(AssertionError a)
    		{
    			LOG.info("Input field " + inputFieldLables.get(i).getText() + " is enabled");
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
	
	private boolean isPossibleToAddComment(String isEditable) throws Exception
	{
		boolean isSuccess = false;
		try
		{
			String commentIcon = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "CommentIcon");
			String addCommentButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "AddCommentButton");
			String addCommentPopUpCloseIcon = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "CommentpopupCloseIcon");
			this.waitUntilElementIsClickable(By.xpath(commentIcon));
			if(isEditable.equalsIgnoreCase("yes"))
			{
				this.Click(By.xpath(commentIcon));
				this.waitUntilElementIsClickable(By.xpath(addCommentButton));
				this.waitUntilElementIsClickable(By.xpath(addCommentPopUpCloseIcon));
				this.Click(By.xpath(addCommentPopUpCloseIcon));
			}
			else if(isEditable.equalsIgnoreCase("No"))
			{
				LOG.info("Adding comment is disabled for current logged in user");
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
	
	private List<String> validateHeadersAvailableInPostingRow()
	{
		//print all the options available in Row
		List<String> headerDetails = new ArrayList<String>();
		String postingRowHeaders = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "PostingRowHeader");
		
    	List<WebElement> headersAvailable = this.driver.findElements(By.xpath(postingRowHeaders));
    	LOG.info("Total columns available are " + headersAvailable.size());
    	
    	for(int i=1;i<headersAvailable.size();i++){
    		WebElement horizontal_scroll = this.driver.findElement(By.xpath("(//div[contains(@class,'table-header-wrap')])[2]//td["+(i+1)+"]")); 
        	((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
        	
        	LOG.info("Column " + i + " title is " + headersAvailable.get(i).getText());
        	
        	WebElement rowInfo = driver.findElement(By.xpath("//div[contains(@class,'scrollable v-table')]//tr[@class='v-table-row']/td["+(i+1)+"]//input")); 
        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rowInfo);
    		
        	String attribute = driver.findElement(By.xpath("//div[contains(@class,'scrollable v-table')]//tr[@class='v-table-row']/td["+(i+1)+"]//input")).getAttribute("readonly");
    		LOG.info("Read Only Attribute value of " + headersAvailable.get(i).getText() + " " + attribute);
    		try
    		{
    			Assert.assertNotNull(attribute);
    			LOG.info("Input field " + headersAvailable.get(i).getText() + " is diabled");
    		}
    		catch(AssertionError a)
    		{
    			LOG.info("Input field " + headersAvailable.get(i).getText() + " is enabled");
    		}
    	}
		return headerDetails;
	}
	
	protected void validateInvoicePage(String isEditable) throws Exception
	{
		String splitter = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "splitter");
		String divisionInputFiels = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "document_default_divisionInputField");
		
		this.addButtonVisibility(isEditable);
		this.emailTemplateValidation();
		this.validateAllFieldsInHeader();
		this.isPossibleToAddComment(isEditable);
		
		this.dragAndDrop(By.xpath(splitter), By.xpath(divisionInputFiels));
		
		this.validateHeadersAvailableInPostingRow();
		
		String firstRowCheckBox = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "firstRowCheckBox");
		this.checkCheckBox(By.xpath(firstRowCheckBox));
		this.validateCRUDOptionsPresentForASelectedRow();
	}
	
	private void validateCRUDOptionsPresentForASelectedRow() throws Exception
	{
		String CaseRowOptionsDD = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "CaseRowOptionsDD");
		String optionsAvailableInDD = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "optionsAvailableInDD");
		this.Click(By.xpath(CaseRowOptionsDD));
		List<WebElement> options = this.driver.findElements(By.xpath(optionsAvailableInDD));
		for(int i=0;i<options.size();i++)
		{
			LOG.info("Option " + i + " is " + options.get(i).getText());
		}
	}
}
