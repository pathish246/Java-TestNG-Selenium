package com.target.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SearchData {

	
	@DataProvider
	public static Object[][] readExcel() throws IOException {
		
		String filePath = "/Users/boney/Desktop/Projects/Java-TestNG-Selenium/src/main/resources/TestData/TestData.xlsx";
		
		File file = new File(filePath);
		
		Object[][] data = null;
		
		List<HashMap<String, String>> listOfMap = new ArrayList<HashMap<String, String>>();
		
		HashMap<String, String> map = null;
		
		FileInputStream fis = new FileInputStream(file);
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheet = wb.getSheet("TargetSearch");
		
		Row row = null;
		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		data = new Object[rowCount+1][sheet.getRow(0).getLastCellNum()];
		
		int runModeIndex = getRunModeIndex(sheet);
		
		for(int i=1;i<=rowCount;i++) {
			
			map = new HashMap<String, String>();
			
			row = sheet.getRow(i);
			
			int columnCount = row.getLastCellNum();
			
			if(sheet.getRow(i).getCell(runModeIndex).getStringCellValue().equals("Yes")) { // if runMode is yes, then only we would run the test case
				
				for(int j=0;j<columnCount;j++) {
				
					map.put(sheet.getRow(0).getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
				
				}
				
				listOfMap.add(map);
			}
		}
		
		int len = listOfMap.size();
		
		data = new Object[len][];
		
		
		int Rowindex = 0;
		
		for(Map<String, String> map1 : listOfMap ) {
		
			data[Rowindex] = new Object[] {map1};
			
			Rowindex++;
		}
			
		return data;		
	}
	
	
	// we would use this index to either add or ignore the test case
	public static int getRunModeIndex(Sheet sheet) {
		int runModeIndex = -1;
		int columnCount = sheet.getRow(0).getLastCellNum();
		for(int i=0;i<columnCount;i++) {
			if(sheet.getRow(0).getCell(i).getStringCellValue().equals("RunMode")) {
				runModeIndex = i;
			}
		}
		return runModeIndex;
	}
}
