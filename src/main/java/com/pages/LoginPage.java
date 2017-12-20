package com.pages;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.ControlFileDefinition;
import com.excel.TestDataReader;
import com.utilities.FrameworkConstants;
import com.utilities.GeneralMethods;

import junit.framework.Assert;

public class LoginPage{
	public GeneralMethods objGeneralFunc = new GeneralMethods();
	TestDataReader objTestDataReader = new TestDataReader();
	public Map<String, String> TestData = null;
	public WebDriver driver;
	
	public Map<String, String> testDataReader(String scriptName)
	{
		FrameworkConstants.sScriptName = scriptName;
		TestData = objTestDataReader.readTestDataFromExcel(ControlFileDefinition.TEST_DATA_SHEET_NAME,
				FrameworkConstants.sScriptName);
		return TestData;
	}
	
	public WebDriver login(String URL, String userName, String password) throws InterruptedException
	{
		//Read chrome driver from location
		System.setProperty("webdriver.chrome.driver",objGeneralFunc.getConfigProperty("chromeDriverPath"));
		    	
		//Open browser
		driver = new ChromeDriver();
		
		//Configuring implicit wait of 20 sec through out script
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//open application
    	driver.get(URL);
    	
    	//maximize the browser
    	driver.manage().window().maximize();
    	
    	//instructed to wait for 180 sec for the visibility of element
    	WebDriverWait wait = new WebDriverWait(driver, 180);
    			
    	//Wait for visibility of element polls for every 2sec
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "UserName"))));
    	
    	//Input user-name to UserField
    	driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "UserName"))).sendKeys(userName);
    	
    	//Input password to Password field
    	driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "Password"))).sendKeys(password);
    	
    	//Click on Login language selection drop-down
    	driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "LoginLanguageSelection"))).click();
    	Thread.sleep(3000);
    	
    	//Select language
    	driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "LanguageEnglish(eng)"))).click();
    	
    	//Click on login button
    	driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "LoginButton"))).click();
    	Thread.sleep(3000);
    	
    	//Validating is application logged in or not
    	Assert.assertEquals(true, driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "ModuleIcon"))).isDisplayed());
    	
    	return driver;
	}
	
	public void dragAndDrop(String drag, String drop) throws InterruptedException
	{
		Thread.sleep(3000);
		//Read and store drag location
    	WebElement element = driver.findElement(By.xpath(drag));
    	
    	//read and store drop location
    	WebElement target = driver.findElement(By.xpath(drop));
    	
    	//drag and drop
    	(new Actions(driver)).dragAndDrop(element, target).perform();
    	Thread.sleep(3000);
	}

}
