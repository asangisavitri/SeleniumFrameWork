package POM_Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public  Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaigns;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
			private WebElement contact;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;

	public WebElement contact() {
		return organizationLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	//Business Logic for Org
	
	public  void clickOrganization()
	{
		organizationLink.click();
	}
	
	//Business logic for signout
	
	public void logout(WebDriver driver)
	{
		Actions act=new Actions(driver);
				act.moveToElement(signoutImg).perform();
		signout.click();
	}
	
	//Business Logic for product
	
		public  void clickProduct()
		{
			productsLink.click();
		}
	
		//Business Logic for Campaigns
		
			public  void clickCampaigns()
			{
				campaigns.click();
			}
			
			//Business Logic for contact
			
			public  void clickContact()
			{
				contact.click();
			}
	
}
