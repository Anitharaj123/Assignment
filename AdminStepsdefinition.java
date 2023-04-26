package stepsdef;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;

public class AdminStepsdefinition {
	public ChromeDriver driver;
	public ChromeOptions Options;

	@Given ("Launch browser and enter url and maximize")
	public void driversetUp() {
		 Options=new ChromeOptions();
		 Options.addArguments("--disable-notifications");
		 driver=new ChromeDriver(Options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	
	@And ("Enter username hari.radhakrishnan@qeagle.com")
	public void usernamedetails() {
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		
		
	}
	@And ("Enter password Leaf@1234")
	public void passworddetail() {
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
	}
	
	
	@When ("Click on Login")
  public void clkLogin() {
	  driver.findElement(By.id("Login")).click();
}
	@And ("handling windows")
	public void handle() {
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		
		Set<String> WindowHAndling=driver.getWindowHandles();
		List<String> Links=new ArrayList<String>(WindowHAndling);
		driver.switchTo().window(Links.get(1));
		driver.findElement(By.xpath("(//div[@class='dialog']//button)[2]")).click();
		
	}
	@And ("shadow element handling")
	public void shadow() throws InterruptedException {
		Shadow dd=new Shadow(driver);
		dd.setImplicitWait(20);
		dd.findElementByXPath("//span[text()='Learning']").click();
		WebElement elment=dd.findElementByXPath("//span[text()='Learning on Trailhead']");
	
		Actions hover=new Actions(driver);
		hover.moveToElement(elment).perform();
		WebElement Elementclick=dd.findElementByXPath("//a[text()='Salesforce Certification']");
		
		hover.moveToElement(Elementclick).perform();
		Elementclick.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Administrator")).click();
	}
	@Then ("Print the Admin Certificates in a List")
	public void listingCertificates() throws InterruptedException {
		List<WebElement> listOfCertificates=driver.findElements(By.xpath("(//div[@class='trailMix-card-body_title']//a)"));
		int count=listOfCertificates.size();
		Thread.sleep(2000);
			for (int i = 1; i <= count; i++) {
				String certificates=driver.findElement(By.xpath("(//div[@class='trailMix-card-body_title']//a)["+i+"]")).getText();
				
				System.out.println(certificates);
				
			}
	}
}
