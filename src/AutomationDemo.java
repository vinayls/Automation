import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomationDemo 
{
	public static WebDriver driver ;
	public static void main(String[] args) 
	{
		try
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Library\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.navigate().to("https://www.google.co.in");
			
			Thread.sleep(5000);
			System.out.println("success");
			driver.close();
			
			/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.navigate().to("https://www.google.co.in");
			Thread.sleep(5000);
			System.out.println("Success");
			driver.close();*/
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
