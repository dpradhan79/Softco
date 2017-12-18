package com.utilities;


public class GlobalConstants
{
	public static String gFunctionalityName = null;
	public static boolean bBrowserLaunched = false;

	public static String gAppErrMsg = null,
						 gErrMsg = null,
						 gAlertConfirmationMsg,
						 sScriptName = null,
						 sPrevScriptName = null,
						 BROWSER_FIREFOX = "firefox",
						 BROWSER_IEXPLORER = "internet explorer",
						 BROWSER_CHROME = "chrome",
						 BROWSER_SAFARI = "safari",
						gCurrentLocale = "en-US",
						gURL = "",
						sSuiteName=null;
	
    public static String[] ENV_URL= {BROWSER_FIREFOX,BROWSER_IEXPLORER,BROWSER_CHROME};
	
	public static boolean bAssertion = true,
						  bSuiteExecution = false,

	//terminate the list of browsers used for execution before the start of the test case execution
						  bKillBrowser = true;

	public static String[] BROWSER_LIST= {BROWSER_FIREFOX,BROWSER_IEXPLORER,BROWSER_CHROME};
	
	
}