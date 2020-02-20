package com.greatcourse.pages;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.greatcourse.utilities.BasePage;

public class HomePage extends BasePage {
	HttpsURLConnection huc = null;
	int respCode = 200;
private String codeText="Priority Codes are on the back of the catalog, mail promotion, or within an advertisement. To ensure that the pricing on the website is the same as what is in your catalog or advertisement, please enter the priority code provided.";
	public String  getTitle() {
		String title =li.getPageTitle();
		return title;
	}
	
	public void click_Have_a_Priority_Code_Elem() {
		li.clickElement(By.cssSelector("[class='icon-info js-action-icon'][title='What are priority codes']"),1);
	}
	
	public String get_what_Are_Priority_codes_elem() {
		return li.getText(By.cssSelector("[class='tooltip-text-desc']"),By.tagName("p"));
	}
	
	public String returnExpectedCodeText() {
		return codeText;
	}
	
	public void verify_Courses_menu() {
		String url = null;
		//WebElement elem = driver.findElement(By.cssSelector("span[class='all-courses-js text-header-nav-medium menu-container nav-arrow-down']"));
		//elem.click();
		WebElement elem2 = driver.findElement(By.cssSelector("div[id='nav'][class=classic]"));

		
		List<WebElement> elems = elem2.findElements(By.tagName("a"));
		for(WebElement ele: elems) {
			url = ele.getAttribute("href");
			System.out.println(url);
			try {
				huc = (HttpsURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				respCode = huc.getResponseCode();
				if(respCode>=400) {
					System.out.println(url+" is a broken link");
				}
				else {
					System.out.println(url+ " is a calid link");
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		driver.quit();
	}
	
	 
} 
