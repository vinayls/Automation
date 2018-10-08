

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Login_ActiTime_Reuse_Methods {
	public static void main(String[] args) {
		WebDriver oBrowser=launchBrowser("Chrome");
		NavigateURL(oBrowser);
		LoginToActiTime(oBrowser, "admin", "manager");
		logOut(oBrowser);
		closeBrowser(oBrowser);
	}
	
	
	/**********************************************
	 * Method Name		: launchBrowser
	 * Purpose			:
	 * Author			:
	 * Reviewer Name	:
	 * Date of written	:
	 * *********************************************
	 */
	public static WebDriver launchBrowser(String sBrowser)
	{
		WebDriver oDriver=null;
		try
		{
			if(sBrowser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\Drivers\\chromedriver.exe");
				oDriver=new ChromeDriver();
			}else if(sBrowser.equalsIgnoreCase("FF"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Library\\Drivers\\geckodriver.exe");
				oDriver=new FirefoxDriver();
			}else if(sBrowser.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Library\\Drivers\\IEDriverServer.exe");
				oDriver=new InternetExplorerDriver();
			}else{
				System.out.println("Invalid browser name");
			}
			
			if(!sBrowser.equalsIgnoreCase("FF")) oDriver.manage().window().maximize();
			return oDriver;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}finally{
			
		}
	}
	
	
	/**********************************************
	 * Method Name		: NavigateURL
	 * Purpose			:
	 * Author			:
	 * Reviewer Name	:
	 * Date of written	:
	 * *********************************************
	 */
	public static void NavigateURL(WebDriver oDriver)
	{
		try{
			oDriver.navigate().to("http://127.0.0.1/login.do");
			oDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			
		}
	}
	
	
	/**********************************************
	 * Method Name		: LoginToActiTime
	 * Purpose			:
	 * Author			:
	 * Reviewer Name	:
	 * Date of written	:
	 * *********************************************
	 */
	public static void LoginToActiTime(WebDriver oDriver, String sUN, String sPWD)
	{
		try{
			oDriver.findElement(By.xpath("//*[@class='textField' and @name='username']")).sendKeys(sUN);
			oDriver.findElement(By.xpath("//*[@class='textField' and @name='pwd']")).sendKeys(sPWD);
			oDriver.findElement(By.xpath(".//*[@id='loginButton']")).click();
			Thread.sleep(5000);
			String sText=oDriver.findElement(By.xpath("//td[text()='Enter Time-Track']")).getText();
			if(sText.equalsIgnoreCase("Enter Time-Track"))
			{
				System.out.println("Pass");
			}else{
				System.out.println("Fail");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			
		}
	}
	
	
	/**********************************************
	 * Method Name		: logOut
	 * Purpose			:
	 * Author			:
	 * Reviewer Name	:
	 * Date of written	:
	 * *********************************************
	 */
	public static void logOut(WebDriver oDriver)
	{
		try{
			oDriver.findElement(By.xpath("//*[@class='logout']")).click();
			Thread.sleep(5000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			
		}
	}
	
	
	/**********************************************
	 * Method Name		: closeBrowser
	 * Purpose			:
	 * Author			:
	 * Reviewer Name	:
	 * Date of written	:
	 * *********************************************
	 */
	public static void closeBrowser(WebDriver oDriver)
	{
		try{
			oDriver.close();
			Thread.sleep(5000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			oDriver=null;
		}
	}
}
