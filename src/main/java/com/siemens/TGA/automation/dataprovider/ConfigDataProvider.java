package com.siemens.TGA.automation.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;

	public ConfigDataProvider() {
		File src = new File("./src/test/resources/Properties/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Error while looking for Config.properties file");
		} catch (IOException e) {
			System.out.println("Error in reading file");
		}
	}

	public String getValue(String keyName) {
		return pro.getProperty(keyName);
	}

}

	

