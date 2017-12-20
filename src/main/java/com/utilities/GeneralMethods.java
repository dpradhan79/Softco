package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class GeneralMethods 
{
    //TestDataReader objTestDataReader = new TestDataReader();


    /**
     * Purpose: Invoke unlock.vbs process in master machine 
     */
    public void invokeUnlockProcessInHub()
    {
        try
        {
            String sVBSFilePath = System.getProperty("user.dir") + FrameworkConstants.JAVA_FILE_PATH_SEPARATOR + "unlock.vbs";
            Runtime rt = Runtime.getRuntime();
            rt.exec("wscript.exe " + sVBSFilePath);
        }
        catch(Exception e)
        {
            System.out.println("Error Exception occured in Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
            
        }
    }

    /**
     * Purpose: Gets Config property
     * @param sKeyName
     * @return String
     */
    public String getConfigProperty(String sKeyName)
    {
        try
        {
            Properties prop = new Properties();
            String sDirectoryFolderPath = System.getProperty("user.dir");

            String sFilePath = sDirectoryFolderPath + FrameworkConstants.JAVA_FILE_PATH_SEPARATOR + FrameworkConstants.CONFIG_PROPERTIES_PATH +"config.properties";

            FileInputStream file = new FileInputStream(sFilePath);
            InputStreamReader input = new InputStreamReader(file,"UTF-8");

            prop.load(input);
            String sValue = prop.getProperty(sKeyName);
            if(sKeyName.toLowerCase().contains("path"))
            {
                return sDirectoryFolderPath + sValue;
            }
            else
            {
                return sValue;
            }

        }
        catch(Exception e)
        {

           System.out.println("Error" + e.getCause().toString());
            return "";
        }
    }

    

    /**
     * Purpose:Returns the date for the key word.
     * @return String 
     */
    public String getDate() 
    {	
        try
        {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dt = sdf.format(cal.getTime());

            return dt;
        }
        catch(Exception e)
        {
        	FrameworkConstants.gErrMsg = e.getMessage();
            return "false";
        }
    }

   

    /**
     * Purpose:Returns the date for the key word.
     * @param sValue 
     * @return String 
     * @throws Exception
     */
    public String getDate(String sValue) throws Exception
    {	  
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dt = sValue;

        if (sValue.trim().equalsIgnoreCase("Today"))
        {
            dt = sdf.format(cal.getTime());
        }

        if (sValue.trim().contains("Today_"))
        {
            String [] arrValues = sValue.split("_");
            int iDays = Integer.parseInt(arrValues[1]);
            cal.add(Calendar.DATE, iDays);
            dt = sdf.format(cal.getTime());
        }
        if (sValue.trim().contains("Today#"))
        {
            String [] arrValues = sValue.split("#");
            int iDays = Integer.parseInt(arrValues[1]);
            cal.add(Calendar.DATE, -iDays);
            dt = sdf.format(cal.getTime());
        }
        return dt;
    }


    public boolean fileExists(String sFileName)
    {		
        try
	    {		
	        File objFile = new File(sFileName);
	        if (objFile.exists()){
	            return true;
	        }		
        }
        
        catch(Exception e)
        {
        	FrameworkConstants.gErrMsg = e.getMessage().toString();
            System.out.println("Error Exception occured while trying to get XPath for the element:" + FrameworkConstants.gErrMsg);
          
        }
	    return false;
    }

    /**
     * @param sPropertiesFileName
     * @param sElementKey
     * @return
     */
    public String getElementLocator(String sPropertiesFileName,String sElementKey)
    {
        boolean bExists = false;
        try
        {			
            Properties prop = new Properties();

            String sFilePath = getConfigProperty("XPathFolderPath") + sPropertiesFileName;

            File newfile = new File(sFilePath);
            bExists = newfile.exists();
            if(!bExists)
            {
            	FrameworkConstants.gErrMsg = "Properties file not displayed in the given path:" + newfile.getAbsolutePath();
                              return "-1";
            } 

            FileInputStream file = new FileInputStream(sFilePath);
            InputStreamReader input = new InputStreamReader(file,"UTF-8");

            prop.load(input);
            String sValue = prop.getProperty(sElementKey);

            return sValue;
        }
        catch(Exception e)
        {
        	FrameworkConstants.gErrMsg = e.getMessage().toString();
            System.out.println("Error Exception occured while trying to get XPath for the element:" + sElementKey + " from file:" + sPropertiesFileName + "\n " + FrameworkConstants.gErrMsg);
            return "-1";
        }
    }
}