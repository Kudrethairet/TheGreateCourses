package com.greatcourse.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasePage {
	public  static WebDriver driver;
	public static GlobalLib li;
	//public  ReadPropFile prop= new ReadPropFile("src/test/resources/selector.properties");
	
	 @BeforeClass
	public void setupClass() {

		li = new GlobalLib(driver);

	}

	@BeforeMethod
	public void setupTest() {
		driver = li.getDriver("Chrome");
		driver.get("https://www.thegreatcourses.com/");

	}

	@AfterMethod
	public void afterSetup() {
		driver.close();
	}

	@AfterClass
	public void teardown() {

		driver.quit();

	}

}
