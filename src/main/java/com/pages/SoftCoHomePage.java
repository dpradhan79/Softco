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
			String byARInvoice = this.reUsableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARInvoiceExpand/CollapseICon");
			String className = this.getAttribute(By.xpath(byARInvoice), "class");
			
			//Validating whether the ICON is in expand / collapse status 
			boolean status = false;
			if(className.contains("closed"))
				status = false;	
			else if(className.contains("open"))
				status = true;
			
			if(status){
				LOG.info(String.format("AR Invoice is already expanded - (By - %s)"));}
			else{
				this.Click(By.xpath(byARInvoice));
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
				LOG.info(String.format("ARProcessingQueue is already expanded - (By - %s)"));}
			else{
				this.Click(By.xpath(byARProcessingQueue));
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
				LOG.info(String.format("byARGlobalSearch is already expanded - (By - %s)"));}
			else{
				this.Click(By.xpath(byARGlobalSearch));
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
}
