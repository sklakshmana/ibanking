package com.ibanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ibanking.utitlities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equalsIgnoreCase("firefox"))
		{		
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath()); 
		driver= new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("chrome"))
		{		
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath()); 
		driver= new ChromeDriver();
		} 
		else if(br.equalsIgnoreCase("ie"))
		{		
		System.setProperty("webdriver.chrome.driver",readconfig.getIepath()); 
		driver= new ChromeDriver();
		} 
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
