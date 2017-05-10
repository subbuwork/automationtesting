package com.selenium.automation.excel;

public class SeleniumExelFileReading {
	public static void main(String[] args) {
	ExcelReadingConfig excelReadConfig = new ExcelReadingConfig("C:\\Users\\subbu\\Desktop\\Testdata.xlsx",0);
	//System.out.println("Data:::"+excelReadConfig.getData(0,0,1));
	excelReadConfig.getAllDataInTheSheet(0);

		
	}

}
