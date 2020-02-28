package com.greatcourse.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReadPropFile extends BasePage {

	Properties prop = new Properties();

	
	public static void main(String[] args)  {
		//Properties prop = new Properties();
		//FileInputStream fips = new FileInputStream("src/test/resources/selector.properties");
		ReadPropFile prop = null;
		prop = new ReadPropFile("src/test/resources/selector.properties");
	String i = 	prop.getPropValue("id");
		System.out.println(i);
		
	}
	public  ReadPropFile(String path) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		
		prop.load(fis);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPropValue(String key) {
		String value = (String) prop.get(key);
		String [] elems = value.split("~");
		if(elems[0].contains("cssSelector")) {
			System.out.println(elems[1]);
		}
		//System.out.println(elems[0]);
		return value;
		
	}
	
	public By getPropValueELem(String key) {
		By by = null;
		//WebElement elem = null;
		WebElement elem=null;
		String value = (String) prop.get(key);
		String [] elems = value.split("~");
		if(elems[0].contentEquals("cssSelector")) {
			by = By.cssSelector(elems[1]);
		}
		else if(elems[0].contentEquals("tagName")) {
			by = By.tagName(elems[1]);
		}
		
		
		return by;
	}
	
	
	
	
	
	
}
