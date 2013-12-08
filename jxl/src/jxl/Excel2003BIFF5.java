package jxl;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;

public class Excel2003BIFF5 extends Subject implements Excel {
    Workbook wb[];
    String fileList[];

    Excel2003BIFF5(String fileList[]) {
	this.fileList = fileList;
    }

    public void updateExcel() {
	wb = new Workbook[fileList.length];
	int i = 0;
	for (i = 0; i < fileList.length; i++) {
	    try {
		wb[i] = Workbook.getWorkbook(new File(fileList[i]));
	    } catch (BiffException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		i = -1;
		try {

		    Thread.sleep(100);
		} catch (InterruptedException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();

		}
		// System.out.println("bi");

	    } catch (IOException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		i = -1;
		try {
		    Thread.sleep(100);
		} catch (InterruptedException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}

		// System.out.println("f2");
	    }
	}
    }

    public void closeExcel() {
	for (int i = 0; i < fileList.length; i++) {
	    wb[i].close();
	}
	wb = null;
    }

    public String getCellString(int fileSeq, int sheetSeq, int rowSeq,
	    int colSeq) {
	String cellString = wb[fileSeq].getSheet(sheetSeq)
		.getCell(colSeq, rowSeq).getContents();
	if (cellString == null) {
	    return "null";
	}
	return cellString;
    }

    public int getFileNum() {
	return wb.length;
    }

    public int getRowNum(int fileSeq, int sheetSeq) {

	return wb[fileSeq].getSheet(sheetSeq).getRows();
    }
}
