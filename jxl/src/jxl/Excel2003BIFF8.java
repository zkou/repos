package jxl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel2003BIFF8 extends Excel2007
{
	Excel2003BIFF8(String[] fileList) throws InvalidFormatException {
		super(fileList.length);
		try {

		for (int i = 0; i < fileList.length; i++) {
			wb[i] = new HSSFWorkbook(new FileInputStream(fileList[i]));
		//	wb[i] = WorkbookFactory.create(new FileInputStream(fileList[i]));
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	}
