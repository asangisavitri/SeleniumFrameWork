package GenericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
	public  void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public  void ScriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
		
	public void switchToWindow(WebDriver driver,String PratilaWindowTitle)
	{
		Set<String>windows=driver.getWindowHandles();
		  Iterator<String>it=windows.iterator();
		  while(it.hasNext())	  
		  {
			  String parentId=it.next();
			  driver.switchTo().window(parentId);
			  if(driver.getTitle().contains(PratilaWindowTitle))
			  {
				  break;
			  }
		  }
	}
}
