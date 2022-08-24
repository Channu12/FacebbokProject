package com.crm.trent.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * It is contains External File specific libraries
 * @author User
 *
 */
public class FileUtility {
	/**
	 * Its used return the value from the  Property file based on key
	 * @param key
	 * @param value
	 * @throws IOException 
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.propertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}

}
