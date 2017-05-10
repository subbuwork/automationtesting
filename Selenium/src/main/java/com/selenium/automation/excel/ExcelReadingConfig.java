
package com.selenium.automation.excel;

import java.io.File;
import java.util.Iterator;

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
	
	public ExcelReadingConfig(String filePath,Integer sheetNumber){
		
		try {
			workbook = WorkbookFactory.create(new File(filePath));
			sheet = workbook.getSheetAt(sheetNumber);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public String getData(Integer rowNum,Integer colNum){
		//sheet =workbook.getSheetAt(sheetNum);
		String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}
	
	public void getAllDataInTheSheet(Integer sheetNum){
		//sheet =workbook.getSheetAt(sheetNum);
		Iterator<Row> iterRow =sheet.rowIterator();
		while(iterRow.hasNext()){
			Row row = iterRow.next();
			System.out.println("Data userName::"+row.getCell(0).getStringCellValue());
			System.out.println("Data password::"+row.getCell(1).getStringCellValue());
		}
		
	
		
	
	}
	
	
	public Integer numberOfRows(){
		Integer rowsCOunt =sheet.getLastRowNum();
		System.out.println("Number of rows:::"+rowsCOunt+1);
		return rowsCOunt;
	}
	

}
