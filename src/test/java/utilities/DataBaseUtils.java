package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseUtils {
	static Connection con;
	static Statement stmt;
	static ResultSet result;
	static int totalCols;
	static ArrayList<String> differences = new ArrayList<String>();

	public static void connectToDB() throws Exception {
		String dbUrl = "jdbc:mysql://localhost:3006/emp";
	    String username = "root";	
	    String password = "Umesh@99";				
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection(dbUrl,username,password);
	    stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
	}
	
	public static void getTablaData(String tableName) throws Exception {
		String query = "select * from "+tableName+";";
		result = stmt.executeQuery(query);
	}
	
	public static int getDBRows() throws Exception {
		result.last();
	    int DBRows = result.getRow();
		result.beforeFirst();
		return DBRows;
	}
	
	public static int getDBCols() throws Exception {
		totalCols = result.getMetaData().getColumnCount();
		return totalCols;
	}
	
	public static void closeConnection() throws Exception {
		con.close();
	}
	
	public static void compareData(ArrayList<String> excelPrimaryKeys,String[][] excelData) throws Exception{
		while (result.next()) {
			int indexofPrimary = excelPrimaryKeys.indexOf(result.getString(1));
			if(indexofPrimary>=0) {
				for(int i=0;i<totalCols;i++) {
					if (!result.getString(i+1).equals(excelData[result.getRow()-1][i])) {
						differences.add("    "+result.getRow()+ "     |   " + (i+1) + "    | " + result.getString(i+1) + " | " + excelData[result.getRow()-1][i]);
					}
				}
			}
		}
		if (differences.size()==0) {
			TextFileUtils.outputWrite("Test Data in DB and Excel is exactly same");
		}else {
		for(String temp:differences) {
			TextFileUtils.outputWrite(temp);
		}}
		TextFileUtils.outputClose();
	}
	
}
