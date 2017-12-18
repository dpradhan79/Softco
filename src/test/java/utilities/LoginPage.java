package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.ControlFileDefinition;
import com.utilities.GeneralMethods;

import junit.framework.Assert;

public class LoginPage{
	public GeneralMethods objGeneralFunc = new GeneralMethods();
	public WebDriver driver;
	
	public void login(String URL, String userName, String password) throws InterruptedException
	{
		//Read chrome driver from location
		System.setProperty("webdriver.chrome.driver",objGeneralFunc.getConfigProperty("chromeDriverPath"));
		    	
		//Open browser
		driver = new ChromeDriver();
		
		//open application
    	driver.get(URL);
    	Thread.sleep(10000);
    	
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
    	
    	//Validating is application logged in or not
    	Assert.assertEquals(true, driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "ModuleIcon"))).isDisplayed());
	}

}
