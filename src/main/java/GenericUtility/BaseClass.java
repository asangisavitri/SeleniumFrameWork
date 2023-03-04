package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM_Object_Repo.Home_Page;
import POM_Object_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public PropertyUtility plib=new PropertyUtility();
	
	@BeforeSuite(groups={"SmokeTest","RegressionTest"})
	
	
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
    @BeforeTest(groups={"SmokeTest","RegressionTest"})
    
    public void BT()
    {
    	System.out.println("Parallel Execution");
    	
	}
    
    @BeforeClass(groups={"SmokeTest","RegressionTest"})
    
    public void BC() throws Throwable
    {
    	//PropertyUtility plib=new PropertyUtility();
		String BROWSER = plib.getKeyvalue("browser");
		//WebDriver driver;
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
	   else
		{
			
			driver=new EdgeDriver();
			
		}
		System.out.println("Launching Browser");
    }
    
    @BeforeMethod(groups={"SmokeTest","RegressionTest"})
    public void BM() throws Throwable
    {
    	//PropertyUtility plib=new PropertyUtility();
    	String URL = plib.getKeyvalue("url");
    	String USERNAME = plib.getKeyvalue("username");
    	String PASSWORD = plib.getKeyvalue("password");
    	
    	//Login to vtiger application 
    	
    	driver.get(URL);
    	Login_Page log= new Login_Page(driver);
    	log.loginToApp(USERNAME, PASSWORD);
    	System.out.println("Login appliaction");
    }
    
    @AfterMethod(groups={"SmokeTest","RegressionTest"})
    
    public void AM()
    {
    	Home_Page home=new Home_Page(driver);
    	home.logout(driver);
    	
    	System.out.println("Logout appliaction");
    }
   @AfterClass(groups={"SmokeTest","RegressionTest"})
   public void AC()
   {
	   System.out.println("Close the Browser");
   }
   @AfterTest(groups={"SmokeTest","RegressionTest"})
   public void AT()
   {
	   System.out.println("Parallel Execution done"); 
   }
   @AfterSuite(groups={"SmokeTest","RegressionTest"})
	
	public void AS()
	{
		System.out.println("DataBase Closed");
	}
}
