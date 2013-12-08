package jxl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

class WorkTable extends JFrame implements Observer {

    private JScrollPane js;
    private JTable dataTable;
    private Lock lock;

    WorkTable(String frameName) {

	super(frameName);
	int i, j, k, s;

	setSize((int) (ConfigClass.wndWidth), (int) (ConfigClass.wndHeigth));
	setLocation((int) (ConfigClass.wndX), (int) (ConfigClass.wndY));

	Container topPanel = getContentPane();

	DefaultTableModel tableModel = null;
	String tmpName[] = ConfigClass.columnName.split(";");
	tableModel = new DefaultTableModel(tmpName, 1);
	dataTable = new JTable(tableModel);

	DefaultTableCellRenderer render = new DefaultTableCellRenderer();
	render.setHorizontalAlignment(SwingConstants.CENTER);
	for (i = 0; i < tmpName.length; i++) {
	    dataTable.getColumnModel().getColumn(i).setCellRenderer(render);
	}

	dataTable.setRowHeight(ConfigClass.rowHeight);
	dataTable.setFont(new Font(ConfigClass.fontNAME, Font.PLAIN,
		ConfigClass.fontSize));
	dataTable.setBackground(new Color(ConfigClass.colorR,
		ConfigClass.colorG, ConfigClass.colorB));
	dataTable.setForeground(new Color(ConfigClass.fontColorR,
		ConfigClass.fontColorG, ConfigClass.fontColorB));
	String columnWidth[] = ConfigClass.columnWidth.split(";");
	for (i = 0; i < columnWidth.length; i++) {
	    dataTable.getColumnModel().getColumn(i)
		    .setPreferredWidth(Integer.parseInt(columnWidth[i]));
	}

	js = new JScrollPane(dataTable,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	tmpName = ConfigClass.factoryName.split(";");
	JButton factoryButton[] = new JButton[tmpName.length];
	for (i = 0; i < tmpName.length; i++) {
	    factoryButton[i] = new JButton(tmpName[i]);
	}
	JButton titleButton = new JButton(ConfigClass.titleName);

	JPanel juniorPanel = new JPanel(new BorderLayout());
	JPanel factoryPanel = new JPanel(new GridLayout(1, 2));

	for (i = 0; i < factoryButton.length; i++) {
	    factoryPanel.add(factoryButton[i]);
	}

	juniorPanel.add("North", factoryPanel);
	juniorPanel.add("Center", js);

	topPanel.setLayout(new BorderLayout());
	topPanel.add("North", titleButton);
	topPanel.add("Center", juniorPanel);

	repaint();
	topPanel.repaint();
	addWindowListener(new WndListener());

	titleButton.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String fileList[] = ConfigClass.excelList.split(";");
		Excel2003BIFF5 excel = new Excel2003BIFF5(fileList);
		update(excel);
	    }

	});

	lock = new ReentrantLock();
    }

    @Override
    public void update(Subject sub) {
	// TODO Auto-generated method stub
	Excel excel = (Excel) sub;
	int i, j, k, s;
	int nextCol = 0;
	int curCol = 0;
	String cellString = null;
	String excelRC[] = ConfigClass.excelRC.split(";");

	int excelRow = Integer.parseInt(excelRC[0]);
	int excelCol = Integer.parseInt(excelRC[1]);

	int readColNum = ConfigClass.readColNum;
	;
	int readRowNum = 0;
	int tableRow = 0;
	int tableCol = 0;

	lock.lock();
	try {
	    excel.updateExcel();
	    ((DefaultTableModel) dataTable.getModel()).getDataVector()
		    .removeAllElements();
	    ((DefaultTableModel) dataTable.getModel()).fireTableDataChanged();

	    for (k = 0; k < excel.getFileNum(); k++) {
		readRowNum = excel.getRowNum(k, 0);
		for (i = 0; i < readRowNum; i++) {
		    for (j = 0; j < readColNum; j++) {
			if (dataTable.getRowCount() <= i) {
			    DefaultTableModel dm = (DefaultTableModel) dataTable
				    .getModel();
			    dm.addRow((Vector) null);
			}
			cellString = excel.getCellString(k, 0, excelRow + i,
				excelCol + j);
			dataTable.setValueAt(cellString, tableRow + i, tableCol
				+ j);
		    }
		}

		tableRow = 0;
		tableCol += readColNum;
	    }
	    excel.closeExcel();
	} finally {
	    lock.unlock();
	}
    }
}
