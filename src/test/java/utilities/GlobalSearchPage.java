package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.config.ControlFileDefinition;

public class GlobalSearchPage extends HomePage{
	
	HomePage obj = new HomePage();
	
	public void searchForADocumentAndClickOnFirstRecord() throws InterruptedException
	{
		//Click on Search button
		driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "SearchForDoc_SearchButton"))).click();
		Thread.sleep(3000);
		
		//Get all the records displayed in results table
		List<WebElement> results = driver.findElements(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "rowsInResultsTable")));
		
		//click on the first record displayed
		results.get(1).click();
	}

}
