package seleniumcodepractice;

import org.testng.annotations.Test;

public class PriorityInTestNg {
	
	public static void main (String[] args) {
	}
	
	@Test(priority=2)
	public static void FirstMethod() {
	System.out.println("This is in 1st method");
}
	@Test(priority=-1)
	public static void SecondMethod() {
	System.out.println("This is in 2nd method");	
}
	@Test(priority=4)
	public static void ThirdMethod() {
	System.out.println("This is in 3rd method ");	
}
	@Test(priority=0)
	public static void ForthMethod() {
	System.out.println("This is in 4th method");	
	}
}
