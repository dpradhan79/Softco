package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.config.ControlFileDefinition;

public class GlobalSearchPage extends HomePage{
	
	HomePage obj = new HomePage();
	
	public int searchAndClickOnFirstRecord() throws InterruptedException
	{
		//Click on Search button
		driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "SearchForDoc_SearchButton"))).click();
		Thread.sleep(3000);
		
		//Get all the records displayed in results table
		List<WebElement> results = driver.findElements(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "rowsInResultsTable")));
		
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
		List<WebElement> results = driver.findElements(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "rowsInResultsTable")));
		
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

}
