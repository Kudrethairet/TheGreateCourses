package com.greatcourse.pages;

import org.openqa.selenium.By;

import com.greatcourse.utilities.BasePage;

public class HomePage extends BasePage {
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
	
	
}
