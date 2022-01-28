package com.siemens.TGA.automation.factory;

import com.siemens.TGA.automation.dataprovider.ConfigDataProvider;

public class DataProviderFactory {
	
	public static ConfigDataProvider getConfigDataProvider() {
		return new ConfigDataProvider();
	}
	

}
