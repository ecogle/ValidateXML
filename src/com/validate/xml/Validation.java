package com.validate.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

public class Validation {
	
	private Logger logger = LogManager.getLogger(Validation.class.getName());
	
	public static void main(String[] args) throws IOException
	{
		File file = new File("my.xml");
		
		Validation val = new Validation();
		
		val.getLogger().debug(Validation.class.getName());
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File("myxsd.xsd"));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(file));
			val.getLogger().debug("XML is validated");
			
		} catch (SAXException e) {
			
			val.getLogger().debug("XML Validation Failed");
			val.getLogger().catching(e);
			
		} finally{
			
		}
		
		FileWriter fw = new FileWriter();
		
		fw.writeMe(new File("myMessage"), "Now is the time for all good me to come to the aid of their country\n");
	}

	public Logger getLogger() {
		return logger;
	}

}
