package pagepkg;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pagetoolsqa {

	WebDriver driver;

	public Pagetoolsqa(WebDriver driver) {
		this.driver = driver;
	}


	// 1 Count links

	public void countLinks()
	{
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println("Total links = "+links.size());
	}


	// 2 Broken links

	@SuppressWarnings("deprecation")
	public void brokenLinks()
	{
	List<WebElement> links = driver.findElements(By.tagName("a"));

	for(WebElement e : links)
	{

	String url = e.getAttribute("href");

	try
	{
	URL u = new URL(url);

	HttpURLConnection h =
	(HttpURLConnection) u.openConnection();

	h.connect();

	if(h.getResponseCode() >= 400)
	{
	System.out.println(url+" broken");
	}
	else
	{
	System.out.println(url+" valid");
	}

	}
	catch(Exception ex)
	{
	}

	}

	}


	// 3 Click Enroll

	public void clickEnroll()
	{
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[4]/div[1]/a")).click();
	}


	// 4 Fill form

	public void fillForm()
	{

	driver.findElement(By.name("firstName")).sendKeys("Test");

	driver.findElement(By.name("lastName")).sendKeys("User");

	driver.findElement(By.name("email")).sendKeys("test@gmail.com");

	driver.findElement(By.name("mobile")).sendKeys("9999999999");

	}

}