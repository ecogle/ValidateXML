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
		
		//logger.
		//System.setProperty("log4j.configurationFile", "configuration.xml");
		Validation val = new Validation();
		
		val.getLogger().debug(Validation.class.getName());
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File("myxsd.xsd"));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File("my.xml")));
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			val.getLogger().debug("XML is validated");
		}
	}

	public Logger getLogger() {
		return logger;
	}

}
