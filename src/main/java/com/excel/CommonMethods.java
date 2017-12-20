package com.excel;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.utilities.FrameworkConstants;
import com.utilities.GeneralMethods;

import jxl.Sheet;
import jxl.Workbook;
/**
 * Purpose: Retrives data from Excel
 */
public class CommonMethods 
{
	static GeneralMethods objGeneralFunc = new GeneralMethods();
	/**
	 * Purpose: Gets next test case row number from the test data
	 * @param sFilePath
	 * @param sSheetName
	 * @param iCurrentRowNo
	 * @return int
	 */
	public int getNextTestCaseRowNumberFromExcel(String sFilePath,String sSheetName,int iCurrentRowNo)
	{
		try
		{
			int iRowCounter = 0;
			Workbook objWorkbook = Workbook.getWorkbook(new File(sFilePath));
			Sheet objSheet = objWorkbook.getSheet(sSheetName);

			int iRowCount = objSheet.getRows();

			for(iRowCounter = iCurrentRowNo + 1;iRowCounter<iRowCount;iRowCounter++)
			{
				if((objSheet.getCell(0,iRowCounter).getContents().equalsIgnoreCase("TestCaseName")) || (objSheet.getCell(0,iRowCounter).getContents().length() == 0))
				{
					break;
				}
			}
			return iRowCounter;

		}
		catch(Exception e)
		{
			FrameworkConstants.gErrMsg = "Exception occured while reading test data:" + e.getMessage();
			return -1;
		}
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
		int iColumnNo = 0;
		try
		{
			Workbook objWorkbook = Workbook.getWorkbook(new File(sTestDataFile));
			Sheet objSheet = objWorkbook.getSheet(sSheetName);
			int iColCount = objSheet.getColumns();
			for(int iColCounter = 0; iColCounter < iColCount; iColCounter++)
			{
				if(!objSheet.getCell(iColCounter, iRowNo.intValue()).getContents().equalsIgnoreCase(sColumnName))
					continue;
				iColumnNo = iColCounter;
				break;
			}

		}
		catch(Exception e)
		{
			FrameworkConstants.gErrMsg = (new StringBuilder("Exception occured:")).append(e.getMessage()).toString();
			return iColumnNo;
		}
		if(iColumnNo == 0)
			FrameworkConstants.gErrMsg = (new StringBuilder("No column with name ")).append(sColumnName).append(" in sheet ").append(sSheetName).append(" at row number ").append(iRowNo).toString();
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
		String sKey = null;
		String sValue = null;
		Map<String, String> objRowData = null;

		try
		{
			objRowData = new HashMap<String, String>();	
			Workbook objWorkbook = Workbook.getWorkbook(new File(sTestDataFile));
			Sheet objSheet = objWorkbook.getSheet(sSheetName);
			int iRowCount = objSheet.getRows();
			int iColCount = objSheet.getColumns();

			if (!(iRowNo <= iRowCount))
			{
				FrameworkConstants.gErrMsg = "No data in " + ((File) objSheet).getName().toString() + " at row:" + iRowNo;
				return objRowData;
			}
			for(int iColCounter = 0;iColCounter<iColCount;iColCounter++)
			{
				sKey = ((Sheet) objSheet).getCell(iColCounter,0).getContents();
				sKey = sKey.trim();
				sValue = ((Sheet) objSheet).getCell(iColCounter,iRowNo).getContents();
				sValue = sValue.trim();
				sValue = objGeneralFunc.getDate(sValue);
				sValue = getTestDataUniqueValue(sValue);
				if((!sValue.equalsIgnoreCase("Null")) && (sValue.trim().length()!=0))
				{
					objRowData.put(sKey,sValue);
				}
			}
			objWorkbook.close();	
		}

		catch(Exception e)
		{
			FrameworkConstants.gErrMsg = "Exception Occured:" + e.getMessage();
		}

		return objRowData;
	}
	/**
	 * Purpose: Replaces date and time for UNIQUE keyword in test data
	 * @param sValue
	 * @return String
	 */
	public String getTestDataUniqueValue(String sValue){
		String sTemp;
		sTemp = sValue.toUpperCase();
		if (sTemp.contains("UNIQUE")){
			sTemp = getUniqueName(sTemp);
			return sTemp ;			  
		}
		return sValue;
	}
	/**
	 * Purpose: Get unique name by appending date and time
	 * @param String sName
	 * @return String
	 */
	public String getUniqueName(String sName) {
		Calendar rightNow = Calendar.getInstance();
		if (sName == "") {
			return sName;
		} else {
			String sNewName = sName.replace("UNIQUE", "" + rightNow.get(Calendar.YEAR) + rightNow.get(Calendar.MONTH) + rightNow.get(Calendar.DAY_OF_MONTH) + rightNow.get(Calendar.HOUR) + rightNow.get(Calendar.MINUTE)+ rightNow.get(Calendar.SECOND));
			return sNewName;
		}
	}
	/**
	 * Purpose: Get excel row count
	 * @param sTestDataFile
	 * @param sSheetName
	 * @return int
	 */
	public int getExcelRowCount(String sTestDataFile,String sSheetName)
	{
		int iRowCount;
		try
		{
			Workbook objWorkbook = Workbook.getWorkbook(new File(sTestDataFile));
			Sheet objSheet = objWorkbook.getSheet(sSheetName);
			iRowCount = objSheet.getRows();
			objWorkbook.close();
		}
		catch(Exception e)
		{
			FrameworkConstants.gErrMsg = "Exception Occured.!!" + e.getMessage();
			return 0;
		}
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
		int iRowNo = -1;
		try
		{
			String sCurrentRowValue;
			Workbook objWorkbook = Workbook.getWorkbook(new File(sTestDataFile));
			Sheet objSheet = objWorkbook.getSheet(sSheetName);
			int iRowCount = objSheet.getRows();
			for(int iRowCounter = 0; iRowCounter < iRowCount; iRowCounter++)
			{
				sCurrentRowValue = objSheet.getCell(iColumnNo, iRowCounter).getContents();
				if(sCurrentRowValue.equalsIgnoreCase(sRowValue))
				{
					iRowNo = iRowCounter;
					break;
				}
			}
		}
		catch(Exception e)
		{
			FrameworkConstants.gErrMsg = "Exception Occured.!!" + e.getMessage();
			return 0;
		}
		if(iRowNo < 0) FrameworkConstants.gErrMsg = (new StringBuilder("No row with value ")).append(sRowValue).append(" in sheet ").append(sSheetName).append(" at column number ").append(iColumnNo).toString();

		return iRowNo;
	}
}
