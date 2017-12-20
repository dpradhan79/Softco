package com.testdata.excel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.utilities.FrameworkConstants;
import com.utilities.GeneralMethods;

import jxl.Sheet;
import jxl.Workbook;
/**
 * Purpose: Retrieves config sheet data from Excel
 */
public class Configs 
{
	CommonMethods info=new CommonMethods();
	GeneralMethods objGeneralFunc = new GeneralMethods();
	/**
	 * Purpose: Read Configuration data
	 * @param sSheetName
	 * @return Map<String, String>
	 */
	public Map<String,String>readConfigDataFromExcel(String sSheetName)
	{
		String sFilePath = objGeneralFunc.getConfigProperty("TestDataFilePath");
		try
		{

			String sKey = null;
			String sValue = null;
			Map<String, String> objConfigData = new HashMap<String,String>();

			Workbook objWorkbook = Workbook.getWorkbook(new File(sFilePath));
			Sheet objSheet = objWorkbook.getSheet(sSheetName);
			int iRowCount = objSheet.getRows();

			for(int iRowCounter = 1;iRowCounter<iRowCount;iRowCounter++)
			{
				sKey = objSheet.getCell(0,iRowCounter).getContents();
				sValue = objSheet.getCell(1,iRowCounter).getContents();
				sValue = info.getTestDataUniqueValue(sValue);
				if(!(sKey.equalsIgnoreCase("Comment")) && (!(sValue.equalsIgnoreCase(null)) && (sValue.trim().length()!=0)))
				{
					objConfigData.put(sKey, sValue);
				}
			}
			return objConfigData;
		}
		catch(Exception e)
		{
			FrameworkConstants.gErrMsg = "Exception occured while reading config data:" + e.getMessage();
			return null;
		}
	}
	/**
	 * Purpose: Get browser assigned from Hosts sheet
	 * @param sIPAddress
	 * @return String[]
	 */
	public String[] getBrowsersAssignedFromConfigSheetInExcel(String sIPAddress)
	{
		int iLoopCounter = 0;
		try
		{
			//Read data from config sheet
			Workbook objWorkbook = Workbook.getWorkbook(new File(objGeneralFunc.getConfigProperty("TestDataFilePath")));
			Sheet objSheet = objWorkbook.getSheet("Hosts");
			int iRowCount = objSheet.getRows();
			String browsers[] = new String[iRowCount-1];
			for(int iRowCounter=1;iRowCounter<iRowCount;iRowCounter++)
			{
				String sCurrentIPAddress = ((Sheet) objSheet).getCell(1,iRowCounter).getContents();
				if(sCurrentIPAddress.equals(sIPAddress))
				{
					//get BrowserName
					browsers[iLoopCounter] = ((Sheet) objSheet).getCell(2,iRowCounter).getContents();
					browsers[iLoopCounter] = browsers[iLoopCounter] + ".exe";
					iLoopCounter = iLoopCounter + 1;
				}
			}
			return browsers;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
