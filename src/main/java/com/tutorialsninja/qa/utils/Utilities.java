package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	
	public static String generateEmailWithTimestamp() {
		Date date = new Date();
		return "hariharan"+date.toString().replace(' ', '_').replace(':', '_')+"@gmail.com";
	}
	
	public static Object[][] getTestDataFromExcel(String sheetName) {
		FileInputStream file;
		XSSFWorkbook wb = null;
		try {
			file = new FileInputStream("src/main/java/com/tutorialsninja/qa/testdata/tutorialsNinjaTestData.xlsx");
			wb = new XSSFWorkbook(file);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet(sheetName); 
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rows][cols];
		for(int i=0; i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0; j<cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
	}
	
	public static String getScreenshot(WebDriver driver, String testName) {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File temp = ss.getScreenshotAs(OutputType.FILE);
		File perm = new File(System.getProperty("user.dir")+"\\screenshots\\"+testName+".png");
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
	}
}
