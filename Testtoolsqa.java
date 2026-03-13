package testpkg;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basepkg.Basetoolsqa;
import pagepkg.Pagetoolsqa;

public class Testtoolsqa extends Basetoolsqa {

	Pagetoolsqa ob;
	private String parent;


	@BeforeTest
	public void start()
	{
	setup();
	ob = new Pagetoolsqa(driver);
	}


	@Test(priority = 1)
	public void countLinks()
	{
	ob.countLinks();
	}



	@Test(priority = 2)
	public void brokenLinks()
	{
	ob.brokenLinks();
	}



	



	@Test(priority = 3)
	public void switchTab()
	{

	parent = driver.getWindowHandle();

	Set<String> all = driver.getWindowHandles();

	for(String s : all)
	{
	if(!s.equals(parent))
	{
	driver.switchTo().window(s);
	}
	}

	}

	@Test(priority = 4)
	public void verifyTitle()
	{

	String title = driver.getTitle();

	System.out.println(title);

	}



	@Test(priority = 5)
	public void verifyURL()
	{

	Assert.assertTrue(
	driver.getCurrentUrl().contains("toolsqa")
	);

	}

	@Test(priority = 6)
	public void switchBack()
	{

	driver.switchTo().window(parent);

	}
	
	@Test(priority = 7)
	public void clickEnroll()
	{
	ob.clickEnroll();
	}
	
	@Test(priority = 8)
	public void fillForm()
	{

	ob.fillForm();

	}


	@Test(priority = 9)
	public void screenshot() throws IOException
	{

	TakesScreenshot ts =
	(TakesScreenshot) driver;

	File src =
	ts.getScreenshotAs(OutputType.FILE);

	FileUtils.copyFile(
	src,
	new File("./screenshot/img.png")
	);

	}

	}