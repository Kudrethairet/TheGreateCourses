package com.greatcourse.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.greatcourse.pages.HomePage;
import com.greatcourse.utilities.BasePage;

public class smokeTest extends BasePage {
	HomePage hp = new HomePage();
	
	@Test
	public void VerifiedHomePage() {
		assertEquals(hp.getTitle(), "Online Courses & Lectures for Home Study and Lifelong Learning");
		hp.click_Have_a_Priority_Code_Elem();
		assertEquals(hp.get_what_Are_Priority_codes_elem(), hp.returnExpectedCodeText());
		hp.verify_Courses_menu();
	}

}
