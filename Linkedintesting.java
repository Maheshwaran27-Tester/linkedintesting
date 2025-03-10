package linkedin.linkedintesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkedintesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        //WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
	        	 try {
	                 //  LinkedIn login page
	                 driver.get("https://www.linkedin.com/login");
	                 driver.manage().window().maximize();
	                 Thread.sleep(2000);

	                 // Login to LinkedIn
	                 driver.findElement(By.id("username")).sendKeys("maheshwaran27112@gmail.com");
	                 driver.findElement(By.id("password")).sendKeys("Mahesh27112@");
	                 driver.findElement(By.xpath("//button[@type='submit']")).click();
	                 Thread.sleep(5000);

	                 // Search for a name
	                 String searchName = "maheshwaran k";
	                 WebElement searchBox = driver.findElement(By.xpath("//input[contains(@class,'search-global-typeahead__input')]"));
	                 searchBox.sendKeys(searchName);
	                 searchBox.sendKeys(Keys.ENTER);
	                 Thread.sleep(5000);

	                 // Print search results
	                 List<WebElement> searchResults = driver.findElements(By.xpath("//span[contains(@class, 'entity-result__title-text')]"));
	                 System.out.println("Search results for: " + searchName);
	                 for (WebElement result : searchResults) {
	                     System.out.println(result.getText());
	                 }
	                 WebElement searchBox1 = driver.findElement(By.xpath("//div[@class='DJSKSBNYHAhYeGRNZWODrdeTvCeLpwyxPa']"));
	                 searchBox1.click();
	                 Thread.sleep(5000);
	                 WebElement searchBox2 = driver.findElement(By.xpath("//span[@class='link-without-visited-state']"));
	                 searchBox2.click();
	                 Thread.sleep(5000);
	                 // another way Navigate to My Network (Connections)
//	                 driver.get("https://www.linkedin.com/mynetwork/invite-connect/connections/");
//	                 Thread.sleep(5000);

	                 // Print connections
	                 List<WebElement> connections = driver.findElements(By.xpath("////span[contains(@class,'mn-connection-card__name')]"));
	                 System.out.println("\nYour Connections:");
	                 for (WebElement connection : connections) {
	                     System.out.println(connection.getText());
	                 }
	                 List<WebElement> connectioncount=driver.findElements(By.xpath("//span[contains(@class,'mn-connection-card__name')]"));
	                 // xpath //span[contains(@class,'mn-connection-card__name')]
	           		System.out.println("my connection list is ="+connectioncount.size());
	             } finally {
	                 // Close the browser
	                 //driver.quit();
	             }	}}
	}

}
