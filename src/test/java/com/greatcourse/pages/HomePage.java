package com.greatcourse.pages;

import javax.net.ssl.HttpsURLConnection;

import com.greatcourse.utilities.BasePage;
import com.greatcourse.utilities.ReadPropFile;

public class HomePage extends BasePage {
	HttpsURLConnection huc = null;
	public ReadPropFile prop = new ReadPropFile("src/test/resources/selector.properties");

	int respCode = 0;
	private String codeText = "Priority Codes are on the back of the catalog, mail promotion, or within an advertisement. To ensure that the pricing on the website is the same as what is in your catalog or advertisement, please enter the priority code provided.";

	public String getTitle() {
		String title = li.getPageTitle();
		return title;
	}

	public void click_Have_a_Priority_Code_Elem() {
		li.clickElement(prop.getPropValueELem("HaveAPriorityCodeElem"), 1);
	}

	public String get_what_Are_Priority_codes_elem() {
		return li.getText(prop.getPropValueELem("WhatArePriorityCodeElem"), prop.getPropValueELem("pTage"));
	}

	public String returnExpectedCodeText() {
		return codeText;
	}

	public void clickSignInElem() {

		li.clickElement(prop.getPropValueELem("LoginButtonElem"));
	}

	public void clickCreateAnAccount() {
		li.clickElement(prop.getPropValueELem("CreateAccountElem"));
	}

	public void verify_Courses_menu() {

		li.verifyURL(prop.getPropValueELem("CourseElem"), prop.getPropValueELem("CourseTageElem"));
	}

}
