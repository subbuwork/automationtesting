package com.selenium.automation.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SeleniumExelFileReadingUsingForLoop {
	public static void main(String[] args) {
		
     try {
    	//Loading xcel file from local system..
    	File file = new File("C:\\Users\\subbu\\Desktop\\Testdata.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
		
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
		Integer rowCount = xssfSheet.getLastRowNum();
		System.out.println("No of rows in the sheet is:"+rowCount);
		
		for(int i=0;i<rowCount;i++){
		String  username = xssfSheet.getRow(i).getCell(0).getStringCellValue();
		String password  = xssfSheet.getRow(i).getCell(1).getStringCellValue();
		System.out.println("data from row::"+i+"::user name::"+username+"::password::"+password);
		}
		xssfWorkbook.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}

}
