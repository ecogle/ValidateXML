package com.validate.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileWriter {
	private Logger logger = LogManager.getLogger(FileWriter.class);
	
	public void writeMe(File file, String msg) {
		logger.debug("Entering writeMe");
		try (FileOutputStream fout = new FileOutputStream(file,true)){
			fout.write(msg.getBytes());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
