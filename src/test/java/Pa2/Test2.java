package Pa2;

import org.testng.annotations.Test;

public class Test2 {

	public class TestNgPratice {

		@Test
		public void create()
		{
			int a=2,b=3,c;
			c=a+b;
			System.out.print(+c);
		}
		//@Test(dependsOnMethods="create")
		@Test(invocationCount=2)
		public void modify()
		{
			
			System.out.println("modified");
		}
		
		@Test(dependsOnMethods="create")
		public void delete()
		{
			
			System.out.println("deleted");
		}	

		}


}
