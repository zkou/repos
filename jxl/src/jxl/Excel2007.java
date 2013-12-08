package jxl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel2007  extends Subject implements Excel
{
	protected Workbook wb[];
	
	Excel2007()
	{
		
	}
	Excel2007(int fileNum)
	{
		wb = new Workbook[fileNum];
	}
	Excel2007(String[] fileList) {
		wb = new Workbook[fileList.length];
		try {

			for (int i = 0; i < fileList.length; i++) {
				wb[i] = new XSSFWorkbook(new FileInputStream(fileList[i]));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}
		

	public String getCellString(int fileSeq,int sheetSeq,int rowSeq,int colSeq)
	{
		return null;
	}
	public int getFileNum()
	{
		return wb.length;
	}
	@Override
	public int getRowNum(int fileSeq, int sheetSeq) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateExcel() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void closeExcel() {
		// TODO Auto-generated method stub
		
	}
}
