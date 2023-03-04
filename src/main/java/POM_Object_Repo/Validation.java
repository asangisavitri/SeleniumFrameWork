package POM_Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validation {

	public  Validation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	/*@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement  actualorgnationData;
			
	
	//getter method
	
	public WebElement getActualorgnationData() {
		return actualorgnationData;
	}
	
	//business logic 
	public void organvalidation(WebDriver driver, String data)
	{
		String actData = actualorgnationData.getText();
	
	if(actData.contains(data))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
}*/
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement validate;


	public WebElement getValidate() {
		return validate;
	}
	
	public String organvalidate(WebDriver driver, String actData)
	{
		String data = validate.getText();
		return data;
	
	}
}
