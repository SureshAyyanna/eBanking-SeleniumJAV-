package com.ans.Banking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ans.Banking.utilities.ReadConfig;

public class TestBase {
	WebDriver driver;
	public static Logger log;
	
	ReadConfig readConfig = new ReadConfig();
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String browser) {
		log=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			}
		else if(browser.equals("ie")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			}
		else
			System.out.println("No browser found");
		
		driver.get(baseURL);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//screenShots//"+tname+".png"));
	}
	
}
