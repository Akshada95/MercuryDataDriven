package com.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryDatadrivenTest2 {
	
	public WebDriver driver;
	
  @Test(dataProvider ="getdata")
  public void loginwithValidds(String username, String password) 
  {
	  System.out.println("In loginwithValidds method Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  System.out.println("User has login into Mercury Tours successfully");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  
  @BeforeMethod
  public void getAllCookies() 
  {
	  System.out.println("In getAllCookies under BeforeMethod");
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
	  }
  }

  @AfterMethod
  public void captureScreenshot() throws IOException
  {
	  System.out.println("In captureScreenshot method under AfterMethod");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("F:\\Suvidya_data\\Java_Selenium_Practice\\MercurydatadrivenDemo\\Screenshots\\"));
	  System.out.println("Screenshot is captured successfully");
  }


  @DataProvider
  public Object[][] getdata() {
    
	  Object[][] data=new Object[3][2];
	  data[0][0]="Suvidyap1";
	  data[0][1]="P@ssword1";
	  data[1][0]="Suvidyap2";
	  data[1][1]="P@ssword2";
	  data[2][0]="Suvidyap3";
	  data[2][1]="P@ssword3";
	  
	  return data;
	  
  }
  @BeforeClass
  public void maximizeBrowser()
  {
	  System.out.println("In maximizeBrowser method under BeforeClass");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void deleteAllCookies() 
  {
	  System.out.println("In deleteAllCookies method under AfterClass");
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void enterApplicationURL() 
  {
	  System.out.println("In enterApplicationURL method under BeforeTest");
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
  }

  @AfterTest
  public void dbConnectionClosed() 
  {
	  System.out.println("In dbConnectionClosed under AfterTest");
  }

  @BeforeSuite
  public void openBrowser()
  {
	  System.out.println("In openBrowser method under BeforeSuite");
	  System.setProperty("webdriver.chrome.driver", "G:\\Selenium Setup\\setup1\\4052019\\chromedriver_win32 (21)\\chromedriver.exe");
	  driver=new ChromeDriver();
	  System.out.println("Chrome browser is opened successfully");
	  
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  System.out.println("In closeBrowser method under AfterSuite");
	  driver.close();
  }

}
