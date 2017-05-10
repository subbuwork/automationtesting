
package com.apache.selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author subbu
 *
 */
public class ExcelReadingConfig {
	//This apparoach will read both .xlsx and xls files..
	Workbook workbook;
	Sheet sheet;
	
	public ExcelReadingConfig(String filePath){
		
		try {
			workbook = WorkbookFactory.create(new File(filePath));	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public String getData(Integer sheetNum,Integer rowNum,Integer colNum){
		sheet =workbook.getSheetAt(sheetNum);
		String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}
	
	public List<String> getAllDataInTheSheet(Integer sheetNum){
		sheet =workbook.getSheetAt(sheetNum);
		Iterator<Row> iterRow =sheet.rowIterator();
		List<String> data = new ArrayList<String>();
		while(iterRow.hasNext()){
			Row row = iterRow.next();
			data.add(row.getCell(0).getStringCellValue());
			data.add(row.getCell(1).getStringCellValue());
			System.out.println("Data userName::"+row.getCell(0).getStringCellValue());
			System.out.println("Data password::"+row.getCell(1).getStringCellValue());
			
		}
		
	/*	
		
		Integer numRows = sheet.getLastRowNum();
		System.out.println("Number of rows:::"+numRows);
		for(int i=0;i<numRows;i++){
			System.out.println("Sheet Number::"+i+"Data userName::"+sheet.getRow(i).getCell(0).getStringCellValue());
			System.out.println("Sheet Number::"+i+"Data password::"+sheet.getRow(i).getCell(1).getStringCellValue());
			
		}*/
		System.out.println(data);
		return data;
	}
	
	public Integer rowCount(Integer sheetNum){
		return workbook.getSheetAt(sheetNum).getLastRowNum()+1;
	}

}
