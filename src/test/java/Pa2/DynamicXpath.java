package Pa2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicXpath {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		String key ="webDriver.Edge.driver";
		String value ="src/main/resources/geckodriver.exe";
		System.setProperty(key, value);
		
		WebDriver driver= new EdgeDriver();
	driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(3000);
		String month="March 2023";
		String date="24";
        //driver.findElement(By.xpath("//div[text()='March 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='20']")).click();
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
        driver.findElement(By.xpath("//span[text()='RETURN']")).click();
        String month1="April 2023";
		String date1="20";
        Thread.sleep(4000);
        //driver.findElement(By.xpath("//div[text()='March 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='20']")).click();
        driver.findElement(By.xpath("//div[text()='"+month1+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date1+"']")).click();
	}

}
