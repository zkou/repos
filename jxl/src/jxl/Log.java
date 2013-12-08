/**
 * 
 */
package jxl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JOptionPane;

/**
 * @author kzl
 * 
 */
public class Log extends BufferedWriter {
    private static Log logHandle;
    private Lock lock;

    private Log(Writer out) {
	super(out);
	lock = new ReentrantLock();
    }

    static Log getLogHandle() {
	if (logHandle == null) {
	    try {
		logHandle = new Log(new FileWriter("jxl.log", true));
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Create jxl.log Error",
			"Error", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	    }
	}
	return logHandle;
    }

    public void write(char[] cbuf, int off, int len) {
	lock.lock();
	try {
	    Calendar cal = Calendar.getInstance();

	    try {
		super.write(cal.toString() + ":");
		super.write(cbuf, off, len);
		super.newLine();
		super.flush();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null,
			"write(char[] cbuf, int off, int len)", "Error",
			JOptionPane.ERROR_MESSAGE);
	    }
	} finally {
	    lock.unlock();
	}
    }

    public void write(String s) {
	lock.lock();
	try {
	    Calendar cal = Calendar.getInstance();

	    try {
		super.write(cal.getTime().toString() + ":");
		super.write(s, 0, s.length());
		super.write(System.getProperty("line.separator"));
		super.flush();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null,
			"write(String s, int off, int len)", "Error",
			JOptionPane.ERROR_MESSAGE);
	    }
	} finally {
	    lock.unlock();
	}
    }

}
