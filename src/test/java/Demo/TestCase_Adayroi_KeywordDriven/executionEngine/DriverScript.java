package Demo.TestCase_Adayroi_KeywordDriven.executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import Demo.TestCase_Adayroi_KeywordDriven.config.ActionKeywords;
import Demo.TestCase_Adayroi_KeywordDriven.config.Constants;
import Demo.TestCase_Adayroi_KeywordDriven.utility.ExcelUtils;

public class DriverScript {
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static Method method[];
	public static Properties OR;
	public static String sPageObject;

	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}

	public static void main(String[] args) throws Exception {
		// String sPath = Constants.Path_TestData + Constants.File_TestData;
		// ExcelUtils.setExcelFile(sPath, Constants.Sheet_TestSteps);
		DriverScript driverScript = new DriverScript();
		String Path_DataEngine = Constants.Path_TestData + Constants.File_TestData;
		ExcelUtils.setExcelFile(Path_DataEngine, Constants.Sheet_TestSteps);
		System.out.print("\n Path_DataEngine" + Path_DataEngine);
		// Declaring String variable for storing Object Repository path
		String Path_OR = Constants.Path_OR;
		// Creating file system object for Object Repository text/property file
		FileInputStream fs = new FileInputStream(Path_OR);
		// Creating an Object of properties
		OR = new Properties(System.getProperties());
		// Loading all the properties from Object Repository property file in to OR object
		OR.load(fs);
		System.out.print("\n Path_DataEngineccccccccc\n");
		for (int iRow = 1; iRow <= 8; iRow++) {
			sActionKeyword = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword);
			System.out.print("\n sActionKeyword1" + sActionKeyword);
			//sPageObject = ExcelUtils.getCellData(iRow, Constants.Col_PageObject);
			//System.out.print("\n sPageObject" + sPageObject);
			//execute_Actions();
			
			sPageObject = ExcelUtils.getCellData(iRow, Constants.Col_PageObject);
			System.out.print("\n object = "+ sPageObject);
			driverScript.execute_Actions();
		}
	}

	private static void execute_Actions() throws Exception {
		for(int i=0;i<method.length;i++){
			if(method[i].getName().equals(sActionKeyword)){
				//This is to execute the method or invoking the method
				//Passing 'Page Object' name and 'Action Keyword' as Arguments to this method
				method[i].invoke(actionKeywords,sPageObject);
				System.out.print("\n actionKeywords = "+ actionKeywords);
				System.out.print("\n sPageObject = "+ sPageObject);
				break;
				}
			}
		}
}
