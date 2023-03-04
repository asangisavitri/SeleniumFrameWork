package Organization;

import java.io.FileInputStream;
import java.time.Duration;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import POM_Object_Repo.Home_Page;
import POM_Object_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest extends BaseClass{

	@Test(groups={"SmokeTest","RegressionTest"})
	
		public void createOrg() throws Throwable {
//			PropertyUtility plib=new PropertyUtility();
//			String BROWSER = plib.getKeyvalue("browser");
//			WebDriver driver;
//			if(BROWSER.equalsIgnoreCase("edge"))
//			{
//				WebDriverManager.edgedriver().setup();
//				driver=new EdgeDriver();
//				
//			}
//			else if(BROWSER.equalsIgnoreCase("firefox"))
//			{
//				WebDriverManager.firefoxdriver().setup();
//				driver=new FirefoxDriver();
//				
//			}
//			else if(BROWSER.equalsIgnoreCase("chrome"))
//			{
//				WebDriverManager.chromedriver().setup();
//				driver=new ChromeDriver();
//				
//			}
//		   else
//			{
//				
//				driver=new EdgeDriver();
//				
//			}
//			
			//launching browser
			
			//System.setProperty("webDriver.Edge.driver","C:\\geckodriver-v0.32.0-win32\\msedgedriver.exe");
			/*String key ="webDriver.Edge.driver";
			String value ="src/main/resources/geckodriver.exe";
			System.setProperty(key, value);
			
			WebDriver driver= new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("http://localhost:8888/");*/
		
			driver.manage().window().maximize();
			
			//property file
			
			
//			String UR = plib.getKeyvalue("url");
//			String UNAME = plib.getKeyvalue("username");
//			String PASS = plib.getKeyvalue("password");
			
			//or
			
			/*FileInputStream fis= new FileInputStream("./src/test/resources/common.properties.txt");
			Properties pro= new Properties();
			pro.load(fis);
			
		      String URL = pro.getProperty("url");
		      String USERNAME = pro.getProperty("username");
			  String PASSWORD = pro.getProperty("password");*/
			
//			driver.get(UR);
//			//POM class
//			Login_Page log= new Login_Page(driver);
//			log.loginToApp(UNAME, PASS);
//			
			//OR
			/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UNAME);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
			driver.findElement(By.xpath("//input[@type='submit']")).click();*/
			
			
//			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
//			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
//			driver.findElement(By.xpath("//input[@type='submit']")).click();
		
			//Fetch data from excel
//			Random ran= new Random();//avoid duplicate data
//			int rannum= ran.nextInt(1000);
			
			//or
			//Fetch data from excel using generic utlity 
			
			
			
			
			JavaUtility jlib=new JavaUtility();
			int rannum = jlib.getRanDomNum();
			
			//click on organozation link
			Home_Page home=new Home_Page(driver);
			home.clickOrganization();
			//or
			
			/*driver.findElement(By.linkText("Organizations")).click();*/
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			ExcelUtility elib= new ExcelUtility();
			Thread.sleep(1000);
			String Org = elib.getExcelData("Organization", 0, 0)+rannum;
			 
			 
			/*FileInputStream fis1= new FileInputStream("./src/test/resources/ExcelFetch.xlsx");
			Workbook book=WorkbookFactory.create(fis1);
			Sheet sh= book.getSheet("Organization");
			Row row=sh.getRow(0);
			Cell celnum=row.getCell(0);
			String orgname = celnum.getStringCellValue()+rannum;//avoid duplicate data with concatenation*/
			 
			driver.findElement(By.name("accountname")).sendKeys(Org);
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			Thread.sleep(3000);
			//String actData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
			Assert.assertEquals(Org, actData);
			/*if(actData.contains(Org))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}*/
			//handling pop up
			
			//Alert alt=driver.switchTo().alert();
			//String text = alt.getText();
			//System.out.println(text);
			//alt.accept();
			//alt.dismiss();
			
			//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			//driver.findElement(By.linkText("Sign Out")).click();
			
			//Or
			
			//home.logout(driver);

	}

}
