package com.crm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtilsClass {
	
	public static long Page_Timeout=20;
	public static long Implicit_Timeout=100;
	
	public static String TESTDATA_SHEET_PATH= "C:\\Users\\Pinkeym\\Java Testing\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String SheetName){
		FileInputStream file=null;
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
		sheet=(Sheet) book.getSheet(SheetName);
		Object[][] data= new Object[((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum()][((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum()];
		for(int i=0;i<((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum(); i++) {
			for(int k=0;k<((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum(); k++) {
				data[i][k]= ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i+1).getCell(k).toString();
				
			}
			
		
			
			
		}
		return data;
	}

}
