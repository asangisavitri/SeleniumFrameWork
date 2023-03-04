package Pa2;

import org.testng.annotations.Test;


public class TestNgPratice {

	@Test(priority=1)
	public void create()
	{
		
		System.out.println("created");
	}
	@Test(priority=1)
	public void modify()
	{
		
		System.out.println("modified");
	}
	
	@Test(priority=2)
	public void delete()
	{
		
		System.out.println("deleted");
	}	

	}
