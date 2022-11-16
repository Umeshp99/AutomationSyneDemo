package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtils {
	ZonedDateTime date = ZonedDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
	String fileNameFormat = date.format(formatter);
	
	private BufferedWriter bufferedWriter = null;
	
	public void CreateLogFile() throws Exception {
		File dir = new File("D:/Logs/");
			if(!dir.exists()) {
				System.out.println("dir created");
				dir.mkdir();
			}
			File logFile = new File(dir+"/" + fileNameFormat +".log");
			FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
			bufferedWriter = new BufferedWriter(fileWriter);
	}
	
	public void write(String message) {
		try {
			bufferedWriter.write(message);
			bufferedWriter.close();
		} catch (Exception e) {
			
		}
	}
	
}
