package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcelFile extends ReadFromPropertiesFile {
	
	public HashMap<String, String> readTestDataExcel() throws Exception {

		String filePath = testDataInputPath();

		File file = new File(filePath);

		FileInputStream fis;
		fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet ws = wb.getSheet("Data");

		HashMap<String, String> map = new HashMap<String, String>();

		for (int r = 0; r <= ws.getLastRowNum(); r++) {
			Cell c1 = ws.getRow(r).getCell(0);
			c1.getCellType();
			
			String key = c1.getStringCellValue();
			Cell c2 = ws.getRow(r).getCell(1);
			String value = c2.getStringCellValue();
			map.put(key, value);
		}
		
		return map;
	}

}
