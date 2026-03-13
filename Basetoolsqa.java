package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basetoolsqa {
	public static WebDriver driver;

    public void setup()
    {
        
        driver = new ChromeDriver();
        driver.get("https://www.toolsqa.com/");
        driver.manage().window().maximize();
    }
}