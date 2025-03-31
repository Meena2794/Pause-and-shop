package com.pauseandshop.ecom.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class Fileutility {

	public String getDataFromProperties(String Keys) throws Throwable {
		FileInputStream fis = new FileInputStream("./Environment/commonData.properties");
		Properties p= new  Properties();
		p.load(fis);
		String data = p.getProperty(Keys);
		return data;
		
	}
}
