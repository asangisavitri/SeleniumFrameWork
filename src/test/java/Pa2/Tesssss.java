package Pa2;




import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Tesssss {

	
	
	public static void main(String[] args) throws Throwable {
		
			//System.setProperty("webDriver.Edge.driver","C:\\geckodriver-v0.32.0-win32\\msedgedriver.exe");
			String key ="webDriver.Edge.driver";
			String value ="src/main/resources/geckodriver.exe";
			System.setProperty(key, value);
			
			WebDriver driver= new EdgeDriver();
//		driver.get("http://localhost:8888/");
		
			driver.manage().window().maximize();
			
			//property file
			
			FileInputStream fis= new FileInputStream("./src/test/resources/common.properties.txt");
			Properties pro= new Properties();
			pro.load(fis);
			
		      String URL = pro.getProperty("url");
		      String USERNAME = pro.getProperty("username");
			  String PASSWORD = pro.getProperty("password");
			
			driver.get(URL);
			driver.findElement(By.xpath("//input[@name=\'user_name\']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			
//			driver.findElement(By.xpath("//input[@name=\'user_name\']")).sendKeys("admin");
//			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
//			driver.findElement(By.xpath("//input[@type='submit']")).click();
		
			//Fetch data from excel
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			FileInputStream fis1= new FileInputStream("./src/test/resources/ExcelFetch.xlsx");
			Workbook book=WorkbookFactory.create(fis1);
			Sheet sh= book.getSheet("Organization");
			Row row=sh.getRow(0);
			Cell celnum=row.getCell(0);
			String orgname = celnum.getStringCellValue();
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			
			
			
			
			

	}

}
