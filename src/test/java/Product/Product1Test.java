package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import POM_Object_Repo.Home_Page;
import POM_Object_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product1Test extends BaseClass {
	
	@Test(groups="RegressionTest")
	public  void product1Test() throws Throwable {
//		PropertyUtility plib=new PropertyUtility();
//		String BROWSER = plib.getKeyvalue("browser");
//		WebDriver driver;
//		if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//			
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//			
//		}
//		else if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//			
//		}
//	   else
//		{
//			
//			driver=new EdgeDriver();
//			
//		}
		/*String Key="webDriver.Edge.driver";
		String Value="src/main/resources/geckodriver.exe";
		System.setProperty(Key, Value);
		WebDriver driver=new EdgeDriver();*/
		driver.manage().window().maximize();
		//property file
		
				
//				String URL = plib.getKeyvalue("url");
//				String USERNAME = plib.getKeyvalue("username");
//				String PASSWORD = plib.getKeyvalue("password");
//				
				//OR
		
		/*FileInputStream fis= new FileInputStream("./src/test/resources/common.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		
//		driver.get(URL);
//		//POM class
//		Login_Page log= new Login_Page(driver);
//		log.loginToApp(USERNAME, PASSWORD);
//		
		//OR
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		
		Home_Page home=new Home_Page(driver);
		home.clickProduct();
			
			//or
		//driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//Fetch data from excel
//		Random ran= new Random();//avoid duplicate data
//		int rannum= ran.nextInt(1000);
		
		//or
		//Fetch data from excel using generic utlity 
		
		JavaUtility jlib=new JavaUtility();
		int rannum = jlib.getRanDomNum();
		
		ExcelUtility elib= new ExcelUtility();
		 String product = elib.getExcelData("Product", 0, 0)+rannum;
		 
		 //OR
		
		/*FileInputStream fis2= new FileInputStream("./src/test/resources/ExcelFetch.xlsx");
		Workbook book1= WorkbookFactory.create(fis2);
		Sheet sheet1 = book1.getSheet("Product");
		Row row1 = sheet1.getRow(0);
		Cell cell1 = row1.getCell(0);
		String product = cell1.getStringCellValue()+rannum;*/
		 
		//click on product link
		 
			
		
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		driver.findElement(By.name("Delete")).click();
		Alert alt1=driver.switchTo().alert();
		//alt1.accept();
		alt1.dismiss();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();

		//home.logout(driver);
	}

}
