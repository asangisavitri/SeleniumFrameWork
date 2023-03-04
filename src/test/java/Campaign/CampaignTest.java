package Campaign;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


public class CampaignTest extends BaseClass{

	@Test(groups="SmokeTest")
	public  void campaign() throws Throwable {
//   PropertyUtility plib=new PropertyUtility();
//	String BROWSER = plib.getKeyvalue("browser");
//	WebDriver driver;
//
//	if(BROWSER.equalsIgnoreCase("edge"))
//	{
//		WebDriverManager.edgedriver().setup();
//		driver=new EdgeDriver();
//		
//	}
//	else if(BROWSER.equalsIgnoreCase("firefox"))
//	{
//		WebDriverManager.firefoxdriver().setup();
//		driver=new FirefoxDriver();
//		
//	}
//	else if(BROWSER.equalsIgnoreCase("chrome"))
//	{
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		
//	}
//   else
//	{
//		
//		driver=new EdgeDriver();
//		
//	}
	
	//launching browser
	
	//System.setProperty("webDriver.Edge.driver","C:\\geckodriver-v0.32.0-win32\\msedgedriver.exe");
	/*String key ="webDriver.Edge.driver";
	String value ="src/main/resources/geckodriver.exe";
	System.setProperty(key, value);
	
	WebDriver driver= new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   //driver.get("http://localhost:8888/");*/

	driver.manage().window().maximize();
	
	//property file
	
	//property file
	
	
//	String URL = plib.getKeyvalue("url");
//	String USERNAME = plib.getKeyvalue("username");
//	String PASSWORD = plib.getKeyvalue("password");
//	
	//or
	
	/*FileInputStream fis= new FileInputStream("./src/test/resources/common.properties.txt");
	Properties pro= new Properties();
	pro.load(fis);
	
      String URL = pro.getProperty("url");
      String USERNAME = pro.getProperty("username");
	  String PASSWORD = pro.getProperty("password");*/
	
//	driver.get(URL);
//	//POM class
//	Login_Page log= new Login_Page(driver);
//	log.loginToApp(USERNAME, PASSWORD);
	
	/*driver.findElement(By.xpath("//input[@name=\'user_name\']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@type='submit']")).click();*/
	
	
	
    
  driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
  
  Home_Page home=new Home_Page(driver);
	home.clickCampaigns();
		
		//or
  //driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
  driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
 
  
//Fetch data from excel
//	Random ran= new Random();//avoid duplicate data
//	int rannum= ran.nextInt(1000);
	
	//or
	//Fetch data from excel using generic utlity 
	
	JavaUtility jlib=new JavaUtility();
	int rannum = jlib.getRanDomNum();
	
	ExcelUtility elib= new ExcelUtility();
	 String Cam = elib.getExcelData("Campaign", 0, 0)+rannum;
	 	
	/*FileInputStream fis2= new FileInputStream("./src/test/resources/ExcelFetch.xlsx");
	Workbook book1= WorkbookFactory.create(fis2);
	Sheet sheet1 = book1.getSheet("Campaign");
	Row row1 = sheet1.getRow(0);
	Cell cell1 = row1.getCell(0);
	String Campaigns = cell1.getStringCellValue()+rannum;*/
	
	driver.findElement(By.name("campaignname")).sendKeys(Cam);
	
	   
 
  Thread.sleep(2000);
  //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
  
  //sing out
  //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//driver.findElement(By.linkText("Sign Out")).click();
  
  //home.logout(driver);
}		

}


