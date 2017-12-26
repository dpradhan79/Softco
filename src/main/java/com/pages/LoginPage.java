package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.IConstants;
import com.utilities.ReusableLibs;

import junit.framework.Assert;

public class LoginPage{
	/*public ReusableLibs objReusableLib = new ReusableLibs();
	
	private WebDriver driver;
		
	public WebDriver login(String URL, String userName, String password) throws InterruptedException
	{
		//Read chrome driver from location
		System.setProperty("webdriver.chrome.driver",objReusableLib.getConfigProperty("chromeDriverPath"));
		    	
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
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "UserName"))));
    	
    	//Input user-name to UserField
    	driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "UserName"))).sendKeys(userName);
    	
    	//Input password to Password field
    	driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "Password"))).sendKeys(password);
    	
    	//Click on Login language selection drop-down
    	driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "LoginLanguageSelection"))).click();
    	Thread.sleep(3000);
    	
    	//Select language
    	driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "LanguageEnglish(eng)"))).click();
    	
    	//Click on login button
    	driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "LoginButton"))).click();
    	Thread.sleep(3000);
    	
    	//Validating is application logged in or not
    	Assert.assertEquals(true, driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ModuleIcon"))).isDisplayed());
    	
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
*/
}
