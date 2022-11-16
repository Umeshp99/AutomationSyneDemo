package stepDefinitions;

import java.awt.List;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DataBaseUtils;
import utilities.ExcelUtils;
import utilities.TextFileUtils;

public class DBtoExcelStepDefinition {
	ArrayList<String> excelPrimaryKeys = new ArrayList<String>();
	String[][] excelData = null;
	Scenario scenario;
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@Given("^User Connects to the required DataBase$")
	public void user_Connects_to_the_required_DataBase() throws Throwable {
		DataBaseUtils.connectToDB();
		TextFileUtils.outputInit();
	}

	@When("^User extracts data from the table \"([^\"]*)\"$")
	public void user_extracts_data_from_the_table(String tableName) throws Throwable {
	    DataBaseUtils.getTablaData(tableName);
	}

	@Then("^Compares the DB values with Excel Data$")
	public void compares_the_DB_values_with_Excel_Data() throws Throwable {
	    DataBaseUtils.compareData(excelPrimaryKeys, excelData);
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
	    Assert.assertEquals(DataBaseUtils.getDBCols(), ExcelUtils.getExcelCols());
	}

	@Then("^Verify that row count is same in DB and Excel$")
	public void verify_that_row_count_is_same_in_DB_and_Excel() throws Throwable {
	    Assert.assertEquals(DataBaseUtils.getDBRows(), ExcelUtils.getExcelRows());
	}
}
