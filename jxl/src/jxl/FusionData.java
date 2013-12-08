package jxl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JFrame;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class FusionData {
    public static void main(String[] args) throws FileNotFoundException,
	    IOException, InterruptedException, InvalidFormatException {
	WorkTable wt = new WorkTable(ConfigClass.wndTitle);
	wt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	wt.setVisible(true);

	Calendar cal = Calendar.getInstance();

	cal.getTime();
	Log log = Log.getLogHandle();

	log.write("application start");

	String fileList[] = ConfigClass.excelList.split(";");

	Excel2003BIFF5 excel = new Excel2003BIFF5(fileList);
	// Excel2007 excel = new Excel2007(fileList);
	excel.attach(wt);
	excel.timer(ConfigClass.interval * 1000);

	// excel.invalid();
    }
}
