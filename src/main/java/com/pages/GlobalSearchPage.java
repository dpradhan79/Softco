package com.pages;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.config.IConstants;

public class GlobalSearchPage extends HomePage{
	
	/*private static final Logger LOG = Logger.getLogger(HomePage.class);
	HomePage obj = new HomePage();
	
	public int searchAndClickOnFirstRecord() throws InterruptedException
	{
		//Click on Search button
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "SearchForDoc_SearchButton"))).click();
		Thread.sleep(3000);
		
		//Get all the records displayed in results table
		List<WebElement> results = driver.findElements(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "rowsInResultsTable")));
		
		//Check results count
		int resultsCount = results.size();
		
		//validate results count and click on first record if records displayed
		if(resultsCount==0)
			System.out.println("No records displayed in search results");
		else
		//click on the first record displayed
			results.get(1).click();
			Thread.sleep(5000);
		return resultsCount;
	}
	
	public int clickOnFirstRecord() throws InterruptedException
	{
		//Get all the records displayed in results table
		List<WebElement> results = driver.findElements(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "rowsInResultsTable")));
		
		//Check results count
		int resultsCount = results.size();
		
		//validate results count and click on first record if records displayed
		if(resultsCount==0)
			System.out.println("No records displayed in search results");
		else
		//click on the first record displayed
			results.get(1).click();
			Thread.sleep(5000);
		return resultsCount;
	}*/

}
