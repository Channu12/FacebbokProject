package com.crm.trent.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It is developed using Apache POi libraries, which used to handle Microsoft Excel Sheet
 * @author User
 *
 */
public class ExcelUtility {
	/**
	 * it is used to read the data from Excel-Workbook based on below 
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param String data
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName , int rowNum , int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		return data;
	}
	/**
	 * Used to get the last used row number on specified Sheet
	 * @param SheetName
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	/**
	 * Used to write data back to Excel based on below parameter
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @param Throwable 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public void setDataExcel(String SheetName , int rowNum , int cellNum , String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IConstants.EXCELPATH);
		wb.write(fos);
		wb.close();
	}

}
