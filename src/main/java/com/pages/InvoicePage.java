package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.IConstants;

import junit.framework.Assert;

public class InvoicePage extends GlobalSearchPage{
	
	/*GlobalSearchPage obj = new GlobalSearchPage();
	
	public void emailTemplateValidation()
	{
		//Wait until options menu is clickable
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ElipsesMenu"))));
		
		//Click on options menu
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ElipsesMenu"))).click();
		
		//Click on E-mail
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "EmailButton"))).click();
			
		//verify email pop-up displayed and wait until close icon is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "EmailPopupCloseIcon"))));
		System.out.println("Email pop-up displayed");
		
		//Click on pop-up close icon
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "EmailPopupCloseIcon"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "EmailPopupCloseIcon"))));
	}

	public void addButtonViibility(String status)
	{
		if(status.equalsIgnoreCase("true")){
			//wait for element to be displayed
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "AddButton"))));
			
			//validate element is displayed or not
			Assert.assertEquals(1, driver.findElements(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "AddButton"))).size());
			
			//Print status
	    	System.out.println("Add button displayed");
		}else{
			//Validate element is displayed or not
			Assert.assertEquals(0, driver.findElements(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "AddButton"))).size());
			
			//Print status
			System.out.println("Add button not displayed");
		}
	}
	
	public void validateAllInputFieldsDiableInHeader() throws Exception
	{
		//Store all elements into input fields
    	List<WebElement> inputFields = driver.findElements(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "Header_InputFields")));
    	
    	//Print total elements
    	System.out.println(inputFields.size());
    	
    	//iterate and validate all are disabled or not
    	for(int i=1;i<inputFields.size();i++){
    		if((inputFields.get(i).getAttribute("readonly")).equalsIgnoreCase("true"))
    			System.out.println("Input field "+i+" is diabled");
    		else
    			throw new Exception("Input field "+i+" is not diabled"); 
    	}
	}
	
	public void validateAddCommentButtonDisplayed()
	{
		//click on comment icon
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "CommentIcon"))).click();;
		
		//wait until Add Comment button is displayed
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "AddCommentButton"))));
		System.out.println("Add comment button displayed");
		
		//Close pop-up
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "CommentpopupCloseIcon"))).click();;
	}
	
	public void validateCRUDOptionsOfSelectedRow()
	{
		//Wait till drop down displayed
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "CaseRowOptionsDD"))));
		
		//Click on menu
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "CaseRowOptionsDD"))).click();
		
		//validate options available in Drop-down
		List<WebElement> options = driver.findElements(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "optionsAvailableInDD")));
		
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
	}*/
}
