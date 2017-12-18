package tests;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.config.ControlFileDefinition;
import com.testdata.excel.TestDataReader;
import com.utilities.GeneralMethods;
import com.utilities.GlobalConstants;

import utilities.GlobalSearchPage;
import utilities.HomePage;
import utilities.LoginPage;

public class TC001ReadOnly {

	public Map<String, String> objConfigData = null;
    public Map<String, Map<String, String>> objHostsDetails = null;
    public Map<String, String> objTestData = null;
    boolean bStatus;

    public GeneralMethods objGeneralFunc = new GeneralMethods();
    TestDataReader objTestDataReader = new TestDataReader();
    GlobalSearchPage application = new GlobalSearchPage();

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
    public void testloginpat() throws InterruptedException
    {
    	//Login to application 
    	application.login(objConfigData.get("SoftCo_URL"), objConfigData.get("userName_ReadOnly"), objConfigData.get("password_ReadOnly"));
    	
    	//Navigate to Search for a document 
    	application.navigateToSearchForADocument();
    	
    	//Click on search for the document and click on first record available 
    	application.searchForADocumentAndClickOnFirstRecord();
    
    }
}
