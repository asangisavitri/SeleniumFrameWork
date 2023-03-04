package Pa2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert {
	
	@Test
	public void createContact()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(true, true);
		System.out.println("Step 4");
		System.out.println("Step 5");
		soft.assertAll();
	}

	@Test
	 public void modifycontact()
	 {
		 System.out.println("Step 6");
		 System.out.println("Step 7");
	 }
}
