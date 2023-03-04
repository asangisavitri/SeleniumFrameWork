package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtility {
	
	public String getKeyvalue(String Key) throws Throwable
	{
		
		FileInputStream fis= new FileInputStream("./src/test/resources/common.properties.txt");
		Properties pro= new Properties();
		pro.load(fis);
		String Value= pro.getProperty(Key);
		return Value;
		
	}

}
