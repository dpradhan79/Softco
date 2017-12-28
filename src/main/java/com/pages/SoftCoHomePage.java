package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.config.IConstants;

public class SoftCoHomePage extends PageTemplate {
	private static final Logger LOG = Logger.getLogger(SoftCoHomePage.class);
	public SoftCoHomePage(WebDriver webDriver) {
		super(webDriver);
		
	}
	
	private boolean expandARInvoice() throws Exception
	{
		boolean isSuccess = false;
		try
		{
			this.implicitwait(3);
			String byARInvoice = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARInvoiceExpand/CollapseICon");
			String className = this.getAttribute(By.xpath(byARInvoice), "class");
			
			
			
			//Validating whether the ICON is in expand / collapse status 
			boolean status = false;
			if(className.contains("closed"))
			{
				status = false;	
				
			}
			else if(className.contains("open"))
			{
				status = true;
			}
			
			if(status)
			{
				LOG.info(String.format("AR Invoice is already expanded - (By - %s)", byARInvoice));
				this.implicitwait(2);
			}
			else
			{
				this.waitUntilElementIsClickable(By.xpath(byARInvoice));
				this.Click(By.xpath(byARInvoice));
				this.implicitwait(2);
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
	
	private boolean expandARProcessingQueue() throws Exception
	{
		boolean isSuccess = false;
		try
		{
			String byARProcessingQueue = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARProcessingQueueExpand/CollapseICon");
			String className = this.getAttribute(By.xpath(byARProcessingQueue), "class");
			
			//Validating whether the ICON is in expand / collapse status 
			boolean status = false;
			if(className.contains("closed"))
				status = false;	
			else if(className.contains("open"))
				status = true;
			
			if(status){
				LOG.info(String.format("ARProcessingQueue is already expanded - (By - %s)", byARProcessingQueue));
				this.implicitwait(2);
				}
			else{
				this.waitUntilElementIsClickable(By.xpath(byARProcessingQueue));
				this.Click(By.xpath(byARProcessingQueue));
				this.implicitwait(2);
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
	
	private boolean expandARGlobalSearch() throws Exception
	{
		boolean isSuccess = false;
		try
		{
			String byARGlobalSearch = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARGlobalSearchExpand/CollapseICon");
			String className = this.getAttribute(By.xpath(byARGlobalSearch), "class");
			
			//Validating whether the ICON is in expand / collapse status 
			boolean status = false;
			if(className.contains("closed"))
				status = false;	
			else if(className.contains("open"))
				status = true;
			
			if(status){
				LOG.info(String.format("byARGlobalSearch is already expanded - (By - %s)", byARGlobalSearch));
				this.implicitwait(2);
				}
			else{
				this.waitUntilElementIsClickable(By.xpath(byARGlobalSearch));
				this.Click(By.xpath(byARGlobalSearch));
				this.implicitwait(2);
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
	
	protected boolean navigateToSearchForADocument() throws Exception
	{
		boolean isSuccess = false;
		try
		{
			this.expandARInvoice();
			this.expandARProcessingQueue();
			this.expandARGlobalSearch();
			
			String bySearchforADocument = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARInvoice_SearchForADocument");
			this.Click(By.xpath(bySearchforADocument));
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
	
	protected boolean navigateToMissingClient() throws Exception
	{
		boolean isSuccess = false;
		try
		{
			this.expandARInvoice();
			this.expandARProcessingQueue();
			
			String byMissingClient = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "MissingClientLink");
			this.Click(By.xpath(byMissingClient));
			this.implicitwait(3);
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
	
	protected boolean navigateToSearchForInvoice() throws Exception
	{
		boolean isSuccess = false;
		try
		{
			this.expandARInvoice();
			this.expandARProcessingQueue();
			this.expandARGlobalSearch();
			
			String bySearchforAnInvoice = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARInvoice_searchForAnInvoice");
			this.Click(By.xpath(bySearchforAnInvoice));
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
