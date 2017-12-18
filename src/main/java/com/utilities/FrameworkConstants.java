
package com.utilities;

public class FrameworkConstants {
	/* Path separator for Java based paths and files */
	public static String JAVA_FILE_PATH_SEPARATOR = java.io.File.separator;

	public static String CONFIG_PROPERTIES_PATH = "src" + JAVA_FILE_PATH_SEPARATOR + "main" + JAVA_FILE_PATH_SEPARATOR + "java" + JAVA_FILE_PATH_SEPARATOR + "com" + JAVA_FILE_PATH_SEPARATOR + "config" + JAVA_FILE_PATH_SEPARATOR;

	/* Result Folder path */
	public static String sResultFolderPath = "results";
	/* LogMessage Constants */
	public static String pass = "PASS";
	public static String fail = "FAIL";
	public static String debug = "DEBUG";
	public static String error = "ERROR";
	public static String info = "INFO";
	public static String inHost = " in host ";
	public static String debugStr = " and screenshot path is";
	public static String debugStr1 = "is not successfull in : ";
	public static String logProperties = "log4j.properties";
	public static String excepOccuredInLine = "Exception occured in Line:";
	public static String excepOccured = "Exception occured:";

	/* XSL file */
	public static String sExecSummaryXSLpath = "src" + JAVA_FILE_PATH_SEPARATOR + "main" + JAVA_FILE_PATH_SEPARATOR + "java" + JAVA_FILE_PATH_SEPARATOR + "com" + JAVA_FILE_PATH_SEPARATOR + "reports" + JAVA_FILE_PATH_SEPARATOR;
}