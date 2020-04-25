package sele;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PepperFry {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.pepperfry.com/");
		
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Furniture"));
		action.moveToElement(element).perform();//hover mouse on Furniture menu
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Office Chairs")).click();
		
		driver.findElementByXPath("(//div[@class='cat-wrap-img'])[2]").click();
		
Thread.sleep(5000); 
		
		driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").clear(); 
		driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").sendKeys("50", Keys.ENTER); 
		
		Thread.sleep(8000);
		
		try {
			driver.findElementByXPath("//div[@id='regPopUp']//a[@class='popup-close']").click(); 
			System.out.println("Login popup closed.");
		} catch (Exception e) {
			System.out.println("Login popup not found.");
			e.printStackTrace();
			
		}
			
		driver.findElementByXPath("(//a[@class='clip-heart-icn pf-right'])[2]").click();
		
		WebElement element1 = driver.findElement(By.linkText("Homeware"));
		action.moveToElement(element1).perform();//hover mouse on Homeware menu
		
		driver.findElement(By.linkText("Pressure Cookers")).click();
		
		driver.findElementByXPath("//label[@for='brandsnamePrestige']").click();
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("//label[@for='capacity_db1_Ltr_-_3_Ltr']").click();
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("(//a[@class='clip-heart-icn pf-right'])[5]").click();
		
		String Count=driver.findElementByXPath("(//span[@class='count_alert'])[2]").getText();
		
		System.out.println(Count);
		
		driver.findElementByXPath("//a[@data-tooltip='Wishlist']").click();
		
		Thread.sleep(3000);
		
		
		driver.findElementByXPath("(//a[text()='Add to Cart'])[2]").click();
		
		driver.findElementByXPath("//input[@class='srvc_pin_text']").sendKeys("600128");
		
		driver.findElement(By.linkText("Check")).click();
		
		String Pin=driver.findElementByXPath("(//div[@class='minicart-error'])[1]").getText();
		
		if(Pin.contains("Sorry")) {
			System.out.println("NO DELIVERY");
		}else 
			{
				System.out.println("DELIVER");
			}
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//a[@class='proceed_cta']").click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("PLACE ORDER")).click();
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("(//div[@class='nCheckout__accrodian-header-right'])[1]").click();
		
		Thread.sleep(3000);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("F:\\simple\\screenshot.png"));
		
		driver.close();
		
		}
		
		
		
			}


