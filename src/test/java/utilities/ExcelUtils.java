package utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelUtils {
	static FileInputStream fi;
	static XSSFWorkbook wbook;
	static XSSFSheet wsheet;
	static XSSFCell cell;
	static int totalrows;
	static int totalCols;
	static ArrayList<String> excelPrimaryKeys = new ArrayList<String>();
	
	public static void excelInit(String excelName,String SheetName) throws Exception {
		fi = new FileInputStream("src/test/resources/testData/"+excelName+".xlsx");
		wbook = new XSSFWorkbook(fi);
		wsheet = wbook.getSheet(SheetName);
		totalrows = wsheet.getLastRowNum();
		totalCols = wsheet.getRow(0).getLastCellNum();
	}
	
	public static String getCellData(int rowNum, int colNum) {
		String cellData = "";
		cell  = wsheet.getRow(rowNum).getCell(colNum);
		if(cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			cellData="";
		}else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			int temp = (int)cell.getNumericCellValue();
			cellData = String.valueOf(temp);
		}
		else {
			cellData = cell.getStringCellValue();
		}
		return cellData;
	}
	
	public static int getRowNumber(String rowData) {
		for(int i=0;i<=totalrows;i++) {
			if(getCellData(i, 0).equalsIgnoreCase(rowData)) {
				return i;
			}
		}
		Assert.fail("Given Row not available");
		return 0;
	}
	
	public static String[][] getExcelData(){
		String[][] excelData = new String[totalrows][totalCols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalCols; j++) {
				excelData[i-1][j] = getCellData(i,j);
			}
			excelPrimaryKeys.add(getCellData(i,0));
		}
		return excelData;
	}
	
	public static ArrayList<String> getPrimaryKeys(){
		return excelPrimaryKeys;
	} 
	
	public static int getExcelRows() {
		return totalrows;
	}
	
	public static int getExcelCols() {
		return totalCols;
	}
	
	
}
