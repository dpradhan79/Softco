package com.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.config.IConstants;

public class SoftCoInvoicePage extends PageTemplate {
	SoftCoHomePage homePageObj = new SoftCoHomePage(this.driver);
	private static final Logger LOG = Logger.getLogger(SoftCoInvoicePage.class);
	public SoftCoInvoicePage(WebDriver webDriver) {
		super(webDriver);
		
	}	
	
	protected boolean addButtonVisibility(String searchDocument_isEditable)
	{
		boolean isSuccess = false;
		try
		{
			String addButton = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "AddButton");
			String searchCriteria = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "searchCriteriaButton");
			this.waitUntilElementIsClickable(By.xpath(searchCriteria));
			boolean addButtonStatus = this.isElementDisplayed(By.xpath(addButton));
			if(searchDocument_isEditable.equalsIgnoreCase("yes"))
			{
				if(addButtonStatus)
					LOG.info("Add button Displayed");
				else
					LOG.error("Add button not displayed");
			}
			else if(searchDocument_isEditable.equalsIgnoreCase("No"))
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
	
	protected boolean emailTemplateValidation() throws Exception
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
	
	protected boolean validateAllFieldsInHeader()
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
    			LOG.info("Input field " + inputFieldLables.get(i).getText() + " is diabled");
    		}
    		else
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
	
	protected boolean isPossibleToAddComment(String isEditable) throws Exception
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
}
