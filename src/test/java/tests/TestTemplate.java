package tests;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.google.common.io.Resources;
import com.utilities.ReusableLibs;

public class TestTemplate {
	
	protected WebDriver webDriver = null;
	protected String ChromeDriverExe = null;
	protected String url = null;
	protected String implicitWaitInSecs = null;
	protected String pageLoadTimeOutInSecs = null;
	@Test
	public void Test(ITestContext testContext) throws URISyntaxException
	{
		ReusableLibs reUsableLib = new ReusableLibs();
		this.url = reUsableLib.getConfigProperty("APPURL");
		this.ChromeDriverExe = reUsableLib.getConfigProperty("ChromeDriverExe");
		this.implicitWaitInSecs = reUsableLib.getConfigProperty("ImplicitWaitInSecs");
		this.pageLoadTimeOutInSecs = reUsableLib.getConfigProperty("PageLoadTimeOutInSecs");
		
		
		URL urlFilePath = Resources.getResource(String.format("%s%s%s", "drivers", File.separatorChar, this.ChromeDriverExe));
		String chromedriverPath = Paths.get(urlFilePath.toURI()).toFile().getAbsolutePath();
		System.setProperty("webdriver.chrome.driver",chromedriverPath);
    	this.webDriver = new ChromeDriver();
    	this.webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(this.implicitWaitInSecs), TimeUnit.SECONDS);
    	this.webDriver.manage().timeouts().pageLoadTimeout(Integer.parseInt(this.pageLoadTimeOutInSecs), TimeUnit.SECONDS);
    	this.webDriver.manage().window().maximize();
		
	}

}
