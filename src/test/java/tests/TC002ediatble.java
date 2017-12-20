package tests;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.config.ControlFileDefinition;
import com.testdata.excel.TestDataReader;
import com.utilities.GeneralMethods;
import com.utilities.GlobalConstants;

import utilities.InvoicePage;

public class TC002ediatble {

	public Map<String, String> objConfigData = null;
    public Map<String, String> objTestData = null;
    boolean bStatus;
    WebDriver driver;

    public GeneralMethods objGeneralFunc = new GeneralMethods();
    TestDataReader objTestDataReader = new TestDataReader();
    InvoicePage application = new InvoicePage();

    /**
     * This method is used to get the configuration as well as test case specific details from the test data
     */

    @BeforeClass
    public void setUp()
    {
        try
        {            
            // Read config data from the test data(Excel)
            objConfigData = objTestDataReader.readConfigDataFromExcel(ControlFileDefinition.CONFIG_SHEET_NAME);

            // Read test data based on the script name
            objTestData = objTestDataReader.readTestDataFromExcel(ControlFileDefinition.TEST_DATA_SHEET_NAME,
            		GlobalConstants.sScriptName);
        }
        catch (Exception e)
        {   
            System.out.println("Exception in setup method:" + e.getCause().toString());
        }
    }

    @Test
    public void tc002() throws Exception
    {
    	objTestData = application.testDataReader("tc002editable");
    	
    	//Login to application 
    	driver = application.login(objConfigData.get("SoftCo_URL"), objConfigData.get("userName_Updatable"), objConfigData.get("password_Updatable"));
    	
    	//Navigate to Search for a document 
    	application.navigateToMissingClient();
    	
    	//Click on search for the document and click on first record available 
    	application.clickOnFirstRecord();
    	
    	//Verify Add button not displayed
    	application.addButtonViibility(objTestData.get("AddButtonStatus"));
    	
    	//Validate email pop-up is displayed
    	application.emailTemplateValidation();
    	
    	//Verify AddComment button is displayed
    	application.validateAddCommentButtonDisplayed();
    	
    	//Drag splitter
    	application.dragAndDrop(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "splitter"), objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "document_default_divisionInputField"));
    	
    	//print all the options available in Row
    	List<WebElement> headerAvailable = driver.findElements(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "PostingRowHeader")));
    	for(int i=0;i<headerAvailable.size();i++){
    		WebElement horizontal_scroll = driver.findElement(By.xpath("(//div[contains(@class,'table-header-wrap')])[2]//td["+(i+1)+"]")); 
        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
    		System.out.println(headerAvailable.get(i).getText());
    	}
    	
    	//read check box web element and store to check box web element obj
    	WebElement checkBox = driver.findElement(By.xpath(objGeneralFunc.getElementLocator(ControlFileDefinition.LOCATORSFILENAME, "firstRowCheckBox")));
    	
    	//Wait until element is clickable
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(checkBox));
    	
    	//Print status
    	System.out.println("element is clickable");
    	Thread.sleep(5000);
    	
    	//Click on check-box
    	Actions act = new Actions(driver);
    	act.moveToElement(checkBox).click().build().perform();
    	Thread.sleep(3000);
    	
    	//Validating options available for selected row
    	application.validateCRUDOptionsOfSelectedRow();
    	
    	//logout user
    	application.logout();
    	
    	//Close browser
    	driver.close();
    }
}
