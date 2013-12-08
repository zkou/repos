package jxl;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WndListener implements WindowListener
{
	public void windowClosing(WindowEvent e) 
	{
		System.exit(0);
	}
	public void windowClosed(WindowEvent e) 
	{
//		String inputage = JOptionPane.showInputDialog("closed");

	}

	public void windowOpened(WindowEvent e) 
	{
//		String inputage = JOptionPane.showInputDialog("2");
	}

	public void windowIconified(WindowEvent e)
	{
//		String inputage = JOptionPane.showInputDialog("3ou?");
	}

	public void windowDeiconified(WindowEvent e)
	{
//		String inputage = JOptionPane.showInputDialog("5 oyou?");
	}

	public void windowActivated(WindowEvent e) 
	{
	}

	public void windowDeactivated(WindowEvent e)
	{
//		String inputage = JOptionPane.showInputDialog("h4ou?");
	}
}