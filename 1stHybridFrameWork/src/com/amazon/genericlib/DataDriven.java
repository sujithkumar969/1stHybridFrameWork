package com.amazon.genericlib;

import java.io.FileInputStream;
import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDriven implements AutoConstants {
	
	public static String getData(String sheet, int rowIndex, int cellIndex) {
		
		String s="";
		
		try {
			FileInputStream fs = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fs);
		//	s = wb.getSheet(sheet).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
			s = wb.getSheet(sheet).getRow(rowIndex).getCell(cellIndex).toString();
		} 
		catch (Exception e) {
			
		}
		return s;
	}
	
	// It performs decimal/exponential > long > string. If numbers are more than 10 digits in xlsx //
	public static String toIntegerFormat(String data) {
		
		BigDecimal bigDecimalValue = new BigDecimal(data);
		long longValue = bigDecimalValue.longValue();
		String stringValue = String.valueOf(longValue);
		return stringValue;
	}
}
