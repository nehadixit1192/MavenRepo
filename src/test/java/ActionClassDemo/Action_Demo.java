package ActionClassDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action_Demo {
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Computers')]"))).perform();
		action.click().perform();	
		
		//We can also write above commands as below but we need to use Build() method since we need to do 2 actions i.e. click and findElement.
		//action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Computers')]"))).click().build().perform();
	    
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Laptops & Accessories')]"))).perform();
		
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath("//div[9]//div[2]//div[1]//div[1]//ul[2]//li[2]//a[1]"))).click().build().perform();
		
		//ContextClick is used for right click of the mouse
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//div[@class='celwidget bxw-pageheader is-desktop is-centered']//h1[contains(text(),'Apple Laptops')]"));
		action.moveToElement(element).contextClick().build().perform();
		
		
		//SendKeys in Action Class is used for Sending Keyboard keys.
		Thread.sleep(5000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Macbook");
		action.sendKeys(Keys.ENTER).perform();
	}
}