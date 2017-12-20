package com.testdata.excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.utilities.FrameworkConstants;
import com.utilities.GeneralMethods;

import jxl.Sheet;
import jxl.Workbook;
/**
 * Purpose: Retrieves TestData sheet data from Excel
 */
public class TestData 
{
	static GeneralMethods objGeneralFunc = new GeneralMethods();
	private Map<String, String> objMap = null;
	CommonMethods info=new CommonMethods();
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
		int iStartCounter = 0,iEndCounter = 0;
		String sKey = null;
		String sValue = null;

		String sFilePath = objGeneralFunc.getConfigProperty("TestDataFilePath");

		try
		{
			objMap = new HashMap<String, String>();	
			Workbook objWorkbook = Workbook.getWorkbook(new File(sFilePath));
			Sheet objSheet = objWorkbook.getSheet(sSheetName);
			int iRowCount = objSheet.getRows();

			for(int iRowCounter = 1;iRowCounter<iRowCount;iRowCounter++)
			{
				String sCurTestCaseName = objSheet.getCell(1,iRowCounter).getContents();
				if(sCurTestCaseName.equalsIgnoreCase(sTestCaseName))
				{
					iStartCounter = iRowCounter + 1;
					break;
				}
			}			

			iEndCounter = info.getNextTestCaseRowNumberFromExcel(sFilePath,sSheetName,iStartCounter);

			for(int iLoopCounter = iStartCounter;iLoopCounter<iEndCounter;iLoopCounter++)
			{
				sKey = objSheet.getCell(0,iLoopCounter).getContents();
				sValue = objSheet.getCell(1,iLoopCounter).getContents();
				sValue = info.getTestDataUniqueValue(sValue);
				if((!sValue.equalsIgnoreCase("Null")) && (sValue.trim().length()!=0))
				{
					if(sValue.equalsIgnoreCase("empty"))
					{
						sValue = "";
					}
					objMap.put(sKey,sValue);
				}
			}			
		}
		catch(Exception e)
		{			
			FrameworkConstants.gErrMsg = "Exception occured.." + e.getMessage();
		}
		return objMap;
	}

}
