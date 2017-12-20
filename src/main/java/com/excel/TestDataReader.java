package com.excel;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.utilities.GeneralMethods;
/**
 * Purpose: Works as a master class for all testdata classes
 */
public class TestDataReader
{
	// Read TestDataFilePath file path from config/config.properties
	String sFilePath = objGeneralFunc.getConfigProperty("TestDataFilePath");

	private Map<String, String> objMap = null;
	static GeneralMethods objGeneralFunc = new GeneralMethods();
	CommonMethods info=new CommonMethods();
	Configs Tdata=new Configs();
	TestData TestD=new TestData();

	/**
	 * Purpose: Read Configuration data
	 * @param sSheetName
	 * @return Map<String, String>
	 */
	public Map<String,String>readConfigDataFromExcel(String sSheetName)
	{
		Map<String, String> objConfigData=Tdata.readConfigDataFromExcel(sSheetName);
		return objConfigData;
	}


	/**
	 * Purpose:Reads testData based on test script name
	 * @param sSheetName
	 * @param sTestCaseName
	 * @return Map
	 * @throws IOException 
	 */	
	
	@Test
	public Map<String, String> readTestDataFromExcel(String sSheetName,String sTestCaseName)
	{
		Map<String, String> objMap = TestD.readTestDataFromExcel(sSheetName, sTestCaseName);
		return objMap;
	}

	/**
	 * Purpose: Gets next test case row number from the test data
	 * @param sFilePath
	 * @param sSheetName
	 * @param iCurrentRowNo
	 * @return int
	 */
	public int getNextTestCaseRowNumberFromExcel(String sFilePath,String sSheetName,int iCurrentRowNo)
	{
		int iRowCounter=info.getNextTestCaseRowNumberFromExcel(sFilePath, sSheetName, iCurrentRowNo);
		return iRowCounter;
	}

	/**
	 * Purpose: Replaces date and time for UNIQUE keyword in test data
	 * @param sValue
	 * @return String
	 */
	public String getTestDataUniqueValue(String sValue){
		String sTemp=info.getTestDataUniqueValue(sValue);
		return sTemp;
	}

	/**
	 * Purpose: Get unique name by appending date and time
	 * @param String sName
	 * @return String
	 */
	public String getUniqueName(String sName) {
		String Name=info.getUniqueName(sName);
		return Name;
		
	}


	/**
	 * Purpose: Get column number from excel
	 * @param sTestDataFile
	 * @param sSheetName
	 * @param sColumnName
	 * @param iRowNo
	 * @return int
	 */
	public int getColumnNoFromExcel(String sTestDataFile, String sSheetName, String sColumnName, Integer iRowNo)
	{
		int iColumnNo=info.getColumnNoFromExcel(sTestDataFile, sSheetName, sColumnName, iRowNo);
		return iColumnNo;
	}

	/**
	 * Purpose: Get row data for a given row number in excel
	 * @param sTestDataFile
	 * @param sSheetName
	 * @param iRowNo
	 * @return Map<String, String>
	 * @throws Exception
	 */
	public Map<String, String> getRowDataFromExcel(String sTestDataFile,String sSheetName,Integer iRowNo) throws Exception
	{
		Map<String, String> objRowData=info.getRowDataFromExcel(sTestDataFile, sSheetName, iRowNo);
		return objRowData;
	}

	/**
	 * Purpose: Get excel row count
	 * @param sTestDataFile
	 * @param sSheetName
	 * @return int
	 */
	public int getExcelRowCount(String sTestDataFile,String sSheetName)
	{
		int iRowCount=info.getExcelRowCount(sTestDataFile, sSheetName);
		return iRowCount;
	}
	
	/**
	 * Purpose: Get row number from excel
	 * @param sTestDataFile
	 * @param sSheetName
	 * @param iColumnNo
	 * @param sRowValue
	 * @return int
	 */
	public int getRowNoFromExcel(String sTestDataFile, String sSheetName, int iColumnNo, String sRowValue)
	{
		int iRowNo=info.getRowNoFromExcel(sTestDataFile, sSheetName, iColumnNo, sRowValue);
		return iRowNo;
	}
}


