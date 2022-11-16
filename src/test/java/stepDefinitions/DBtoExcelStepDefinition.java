package stepDefinitions;

import java.util.ArrayList;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DataBaseUtils;
import utilities.ExcelUtils;
import utilities.TextFileUtils;

public class DBtoExcelStepDefinition {
	ArrayList<String> excelPrimaryKeys = new ArrayList<String>();
	String[][] excelData = null;
	
	@Given("^User Connects to the required DataBase$")
	public void user_Connects_to_the_required_DataBase() throws Throwable {
		DataBaseUtils.connectToDB();
		TextFileUtils.outputInit();
	}

	@When("^User extracts data from the table \"([^\"]*)\"$")
	public void user_extracts_data_from_the_table(String tableName) throws Throwable {
	    DataBaseUtils.getTablaData(tableName);
	}
	
	@Then("^intitialize excel \"([^\"]*)\" and Sheet \"([^\"]*)\"$")
	public void intitialize_excel_and_Sheet(String excelName, String sheetName) throws Throwable {
	    ExcelUtils.excelInit(excelName, sheetName);
	}

	@Then("^Convert the Excel in the required collection$")
	public void convert_the_Excel_in_the_required_collection() throws Throwable {
	    excelData = ExcelUtils.getExcelData();
	    excelPrimaryKeys = ExcelUtils.getPrimaryKeys();
	}

	@Then("^Verify that column count is same in DB and Excel$")
	public void verify_that_column_count_is_same_in_DB_and_Excel() throws Throwable {
		try {
			Assert.assertEquals(DataBaseUtils.getDBCols(), ExcelUtils.getExcelCols());
			TextFileUtils.outputWrite("Column Comparison : Column Count in DataBase Output and Excel Data is Same");
			TextFileUtils.outputWrite("Number of Columns : "+ ExcelUtils.getExcelCols() + "\n");
		} catch (Exception e) {
			TextFileUtils.outputWrite("Column Comparison : Column Count in DataBase Output and Excel Data is Not Same");
			TextFileUtils.outputWrite("Number of Columns in DataBase : "+ DataBaseUtils.getDBCols());
			TextFileUtils.outputWrite("Number of Columns in Excel : "+ ExcelUtils.getExcelCols());
			TextFileUtils.outputWrite("\nTerminating the Script due to Column count Mismatch");
			DataBaseUtils.closeConnection();
			System.exit(0);
		}
	    
	}

	@Then("^Verify that row count is same in DB and Excel$")
	public void verify_that_row_count_is_same_in_DB_and_Excel() throws Throwable {
		try {
			Assert.assertEquals(DataBaseUtils.getDBRows(), ExcelUtils.getExcelRows());
			TextFileUtils.outputWrite("Row Comparison : Row Count in DataBase Output and Excel Data is Same");
			TextFileUtils.outputWrite("Number of Rows : "+ ExcelUtils.getExcelRows());
		} catch (Exception e) {
			TextFileUtils.outputWrite("Row Comparison : Row Count in DataBase Output and Excel Data is Not Same");
			TextFileUtils.outputWrite("Number of Rows in DataBase : "+ DataBaseUtils.getDBRows());
			TextFileUtils.outputWrite("Number of Rows in Excel : "+ ExcelUtils.getExcelRows());
		}
	    
	}
	
	@Then("^Compares the DB values with Excel Data$")
	public void compares_the_DB_values_with_Excel_Data() throws Throwable {
		TextFileUtils.outputWrite("\nProceeding with the Data Comparison : \n");
		TextFileUtils.outputWrite("RowNumber | Column | DB Value | Excel Value |");
	    DataBaseUtils.compareData(excelPrimaryKeys, excelData);
	}
}
