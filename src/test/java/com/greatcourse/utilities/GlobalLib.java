package com.greatcourse.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

import org.apache.commons.io.serialization.ClassNameMatcher;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalLib {

	private WebDriver driver;
	
	final static Logger logger = Logger.getLogger(ClassNameMatcher.class);
	public GlobalLib(WebDriver _driver) {
		this.driver = _driver;
	}

	public WebDriver getDriver(String Name) {
		if (driver == null) {
			if (Name.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				BrowserSetUp();
			}
		}
		return driver;
	}

	public void BrowserSetUp() {
		driver = new ChromeDriver();
		logger.info("haha");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public String getPageTitle() {
		String title = null;

		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return title;
	}

	public void VerifyText(String ActualResult, String expectedResult) {
		try {
			assertEquals(ActualResult, expectedResult);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public void waitfor(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());

		}
	}

	public void clickElement(By by, int i) {

		try {
			findElement(by, i).click();
			;
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public WebElement findElement(By by, int i) {
		WebElement codeElem = null;
		try {
			codeElem = null;
			List<WebElement> elems = driver.findElements(by);
			codeElem = elems.get(i);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return codeElem;

	}

	public WebElement findElement(By by1, By by2) {
		WebElement elem = null;
		try {
			WebElement listElems = driver.findElement(by1);
			elem = listElems.findElement(by2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return elem;
	}

	public String getText(By by1, By by2) {

		String text = null;
		try {
			text = findElement(by1, by2).getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return text;
	}

}
