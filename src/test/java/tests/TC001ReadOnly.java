package tests;

public class TC001ReadOnly {

	/*public Map<String, String> objConfigData = null;
    public Map<String, Map<String, String>> objHostsDetails = null;
    public Map<String, String> objTestData = null;
    boolean bStatus;
    WebDriver driver;

    public ReusableLibs objGeneralFunc = new ReusableLibs();
    TestDataReader objTestDataReader = new TestDataReader();
    InvoicePage application = new InvoicePage();

    *//**
     * This method is used to get the configuration as well as test case specific details from the test data
     *//*

    @BeforeClass
    public void setUp()
    {
        try
        {            
            // Read config data from the test data(Excel)
            objConfigData = objTestDataReader.readConfigDataFromExcel(IConstants.CONFIG_SHEET_NAME);

            // Read test data based on the script name
            objTestData = objTestDataReader.readTestDataFromExcel(IConstants.TEST_DATA_SHEET_NAME,
            		FrameworkConstants.sScriptName);
        }
        catch (Exception e)
        {   
            System.out.println("Exception in setup method:" + e.getCause().toString());
        }
    }

    @Test
    public void tc001() throws Exception
    {
    	objTestData = application.testDataReader("tc001ReadOnlyValidatons");
    	
    	//Login to application 
    	driver = application.login(objConfigData.get("SoftCo_URL"), objConfigData.get("userName_ReadOnly"), objConfigData.get("password_ReadOnly"));
    	
    	//Navigate to Search for a document 
    	application.navigateToSearchForADocument();
    	
    	//Click on search for the document and click on first record available 
    	application.searchAndClickOnFirstRecord();
    	
    	//Verify Add button not displayed
    	application.addButtonViibility(objTestData.get("AddButtonStatus"));
    	
    	//Validate email pop-up is displayed
    	application.emailTemplateValidation();
    	
    	//Validate all the input fields in header are disabled
    	application.validateAllInputFieldsDiableInHeader();
    	
    	//Click on invoices
    	driver.findElement(By.xpath(objGeneralFunc.getElementLocator(IConstants.LOCATORSFILENAME, "Invoices"))).click();
    	
    	//Navigate to search for invoices
    	application.navigateToSearchForInvoice();
    	
    	//Search and select 1st record displayed
    	application.searchAndClickOnFirstRecord();
    	
    	//Verify Add button not displayed
    	application.addButtonViibility(objTestData.get("AddButtonStatus"));
    	
    	//Validate email pop-up is displayed
    	application.emailTemplateValidation();
    	
    	//Validate all the input fields in header are disabled
    	application.validateAllInputFieldsDiableInHeader();
    	
    	//Click on invoices
    	driver.findElement(By.xpath(objGeneralFunc.getElementLocator(IConstants.LOCATORSFILENAME, "Invoices"))).click();
    	
    	//Navigate to search for invoices
    	application.navigateToSearchForTimeSheet();
    	
    	//Search and select 1st record displayed
    	application.searchAndClickOnFirstRecord();
    	
    	//Verify Add button not displayed
    	application.addButtonViibility(objTestData.get("AddButtonStatus"));
    	
    	//Validate email pop-up is displayed
    	application.emailTemplateValidation();
    	
    	//Validate all the input fields in header are disabled
    	application.validateAllInputFieldsDiableInHeader();
    	
    	//logout user
    	application.logout();
    	
    	//Close browser
    	driver.close();
    }*/
}
