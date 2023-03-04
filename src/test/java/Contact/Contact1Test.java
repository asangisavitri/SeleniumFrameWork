package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class Contact1Test extends BaseClass {
	
@Test(groups={"SmokeTest","RegressionTest"})
	public  void contact1() throws Throwable {
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
		//or
		/*String key="webDriver.Edge.driver";
		String value="src/main/resources/geckodriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new EdgeDriver();*/
		driver.manage().window().maximize();
		
		
		//property file
		
				
//				String URL = plib.getKeyvalue("url");
//				String USERNAME = plib.getKeyvalue("username");
//				String PASSWORD = plib.getKeyvalue("password");
		
				//OR
		/*FileInputStream fis2= new FileInputStream("./src/test/resources/common.properties.txt");
		Properties pr1= new Properties();
		pr1.load(fis2);
		
		String URL1 = pr1.getProperty("url");
		String USERNAME1 = pr1.getProperty("username");
		String PASSWORD1 = pr1.getProperty("password");*/
		
//       driver.get(URL);
//     //POM class
//		Login_Page log= new Login_Page(driver);
//		log.loginToApp(USERNAME, PASSWORD);
//		
   	/*driver.findElement(By.xpath("//input[@name=\'user_name\']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@type='submit']")).click();*/

	//Fetch data from excel
//	Random ran= new Random();//avoid duplicate data
//	int rannum= ran.nextInt(1000);
	
	//or
	//Fetch data from excel using generic utlity 
	
	JavaUtility jlib=new JavaUtility();
	int rannum = jlib.getRanDomNum();
	
	Home_Page home=new Home_Page(driver);
	home.clickContact();
		
		//or
	
	//driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	/*FileInputStream fi3= new FileInputStream("./src/test/resources/ExcelFetch.xlsx");
	Workbook book2=  WorkbookFactory.create(fi3);
	Sheet sh1= book2.getSheetAt(3);
	Row r1=sh1.getRow(1);
	Cell c1=r1.getCell(0);
	Cell c2=r1.getCell(1);
	//Cell c3=r1.getCell(2);
	String Fname = c1.getStringCellValue()+rannum;
	String Lname = c2.getStringCellValue()+rannum;
	//String Mob = c3.getStringCellValue()+rannum;*/
	//or
	ExcelUtility elib= new ExcelUtility();
	Thread.sleep(1000);
	
	String Fname = elib.getExcelData("Contact", 1, 0)+rannum;
	String Lname = elib.getExcelData("Contact", 1, 1)+rannum;
	String Mb = elib.getExcelData("Contact", 1, 2)+rannum;
   
	
   
	driver.findElement(By.name("firstname")).sendKeys(Fname);
	driver.findElement(By.name("lastname")).sendKeys(Lname);
	driver.findElement(By.name("lastname")).sendKeys(Mb);
	//driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(Mob);
	
	
	driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//driver.findElement(By.linkText("Sign Out")).click();
	
	//home.logout(driver);
				
	}

@Test
public void AdditionalTest()
{
	System.out.println("Addition of 2 numbers");
	
	
	
}
}
