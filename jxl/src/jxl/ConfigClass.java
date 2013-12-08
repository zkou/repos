package jxl;

import java.util.ResourceBundle;

public class ConfigClass {
	private static ResourceBundle configurationBundle = ResourceBundle
			.getBundle("jxl.configuration");

//	public static int tmColumnCount = Integer.parseInt(configurationBundle
//			.getString("ColumnCount"));
	public static int tmDefaultRowCount = 1;
	public static String wndTitle = configurationBundle.getString("WndTitle");
	// public static String wndTitle = "sdf";
	public static String titleName = configurationBundle
			.getString("TitleName");
	public static String factoryName = configurationBundle
			.getString("FactoryName");
	public static int rowHeight = Integer.parseInt(configurationBundle
			.getString("RowHeight"));
	public static int wndWidth = Integer.parseInt(configurationBundle
			.getString("WndWidth"));
	public static int wndHeigth = Integer.parseInt(configurationBundle
			.getString("WndHeight"));
	public static int wndX = Integer.parseInt(configurationBundle
			.getString("WndX"));
	public static int wndY = Integer.parseInt(configurationBundle
			.getString("WndY"));
	public static String excelList = configurationBundle
			.getString("ExcelList");
//	public static String columnName1 = configurationBundle
//			.getString("ColumnName1");
//	public static String columnName2 = configurationBundle
//			.getString("ColumnName2");
	public static String columnName = configurationBundle
			.getString("ColumnName");
	public static int fontSize = Integer.parseInt(configurationBundle
			.getString("FontSize"));
	public static int colorR = Integer.parseInt(configurationBundle
			.getString("ColorR"));
	public static int colorG = Integer.parseInt(configurationBundle
			.getString("ColorG"));
	public static int colorB = Integer.parseInt(configurationBundle
			.getString("ColorB"));
	public static long interval = Long.parseLong(configurationBundle
			.getString("Interval"));
	public static String excelRC = configurationBundle
			.getString("ExcelRC");
	public static int  readColNum = Integer.parseInt(configurationBundle
			.getString("ReadColNum"));
	public static String columnWidth = configurationBundle
			.getString("ColumnWidth");
	public static String fontNAME = configurationBundle
			.getString("FontNAME");
	public static int fontColorR = Integer.parseInt(configurationBundle
			.getString("FontColorR"));
	public static int fontColorG = Integer.parseInt(configurationBundle
			.getString("FontColorG"));
	public static int fontColorB = Integer.parseInt(configurationBundle
			.getString("FontColorB"));

			}
