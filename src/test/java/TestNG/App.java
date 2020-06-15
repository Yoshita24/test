package TestNG;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class App {
	
	static String test = new String() ;
	static WebDriver driver = null;
	@BeforeMethod
	public void launch() {
		System.out.println("Starting launch.") ;
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://ec2-18-219-244-64.us-east-2.compute.amazonaws.com/Project/website/index.php");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@Test
	public static void test_00() {
		System.out.println("Starting test.") ;
		String test = driver.findElement(By.id("PID-ab2-pg")).getText();
		//String test = driver.findElement(By.id("About Us")).getText();
		System.out.println("Test value: "+test);
		assertEquals(test, "This is about page. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		//assertEquals(test,"About Us");
		System.out.println("Test Succeeded!!");
		driver.quit();
	
	}
	
}

