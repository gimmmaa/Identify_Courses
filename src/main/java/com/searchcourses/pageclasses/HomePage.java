package com.searchcourses.pageclasses;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class HomePage {

	/******* Author : Garima ********/
	/* 
	 * aa
	 * All Webelements of Home Page and Associated Operations
	 * 
	 */
	
	/***********Code to Open Browser**************/
	
	//Start Driver and open URL
	public static WebDriver driver;
	public Properties prop;
		//Invoke the Browser
		public void invokeBrowser(String browserName) {
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the browser name :");
			browserName=sc.next();
			if(browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"src\\test\\java\\com\\test\\resources\\drivers\\chromedriver.exe");
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--disable-notifications");
				driver =new ChromeDriver();
				
			}
			else if(browserName.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"src\\test\\java\\com\\test\\resources\\drivers\\geckodriver.exe");
				
				driver=new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("Opera")){
				System.setProperty("webdriver.opera.driver",System.getProperty("user.dir")+"src\\test\\java\\com\\test\\resources\\drivers\\operadriver.exe");
				driver = new OperaDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
			
			//Create object of property file
			if(prop==null) {
				prop=new Properties();
				
				
				try {
					FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"src\\test\\java\\com\\test\\resources\\projectConfig.properties ");
					prop.load(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		 //open the website url
	     public void openURL(String URL) {
	    	 driver.get(prop.getProperty(URL));
	    
	     }
	     
	     
	/*****************WebElements*******************/
	
	//Declare WebElements on Home Page
	
	//Operations of web elements (functions such as click, hover, sendkeys etc)
	
	/***********Code to End Operation**************/
		
		//Close Driver and teardown(quit)
	     public void tearDown() {
	    	 driver.close();
	     }
	     
		//To quit the Browser Instance
	     public void quitBrowser() {
	    	 driver.quit();
	     }
	   //Enter the text function in Text Fields
	     public void enterText(String xpathKey,String data) {
	    	 driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
	     }
	     
	     //To click the elements
	     public void elementClick(String xpathKey) {
	    	driver.findElement(By.xpath(prop.getProperty(xpathKey))).click(); 
	     }
		
}
