package utilities;

import java.io.File;
import java.io.FileWriter;

public class TextFileUtils {
	static FileWriter fw;
	
	public static void outputInit() throws Exception {
		File dir = new File("target/DBToExcelOutput/");
		if(!dir.exists()) {
			System.out.println("dir created");
			dir.mkdir();
		}
		fw = new FileWriter(dir+"/Result.txt");
		outputWrite("Result of DB to Excel Comparison");
		outputWrite("RowNumber | Column | DB Value | Excel Value |");
	}
	
	public static void outputWrite(String message) throws Exception{
		fw.write(message);
		fw.write("\n");
	}
	
	public static void outputClose() throws Exception{
		fw.close();
	}
	
	
	
}
