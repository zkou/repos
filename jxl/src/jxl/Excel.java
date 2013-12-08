package jxl;

public interface Excel {
    // protected String[] fileList;

    public String getCellString(int fileSeq, int sheetSeq, int rowSeq,
	    int colSeq);

    public void updateExcel();

    public void closeExcel();

    public int getFileNum();

    public int getRowNum(int fileSeq, int sheetSeq);
}
