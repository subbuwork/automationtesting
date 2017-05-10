package com.selenium.automation.excel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadConfig {
	XSSFWorkbook workBook;
	XSSFSheet excelSheet;
	//HSSFSheet hssfSheet;// works only with older versions of excel files xls not xlxs
	//HSSFWorkbook hssfWorkbook;
	public ExcelReadConfig(String filePath){
		try {
			File file = new File(filePath);
			FileInputStream fileInputStream = new FileInputStream(file);
			workBook = new XSSFWorkbook(fileInputStream);
			//hssfWorkbook = new HSSFWorkbook(fileInputStream);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getData(Integer sheetNum,Integer rowNum,Integer colNum){
		excelSheet = workBook.getSheetAt(sheetNum);
		//hssfSheet =hssfWorkbook.getSheetAt(sheetNum);
		String data = excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//String data2 =hssfSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println("data2::"+data);
		return data;
	}

}
