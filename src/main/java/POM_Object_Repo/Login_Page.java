package POM_Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	
	public  Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Declaration
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userTextField;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitBtton;


	//getter methods
	
	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSubmitBtton() {
		return submitBtton;
	}
	
	//Business logics
	
	public void loginToApp(String username, String password)
	{
		userTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		submitBtton.click();
	}
	
	
}
