package com.grover.imdb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.grover.imdb.config.Config;

public class CommonComponents {

	WebDriver driver;

	public CommonComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void lunchIDMBApp() {
		driver.get(Config.AppUrl);
	}

	public void tearDown() {
		driver.close();
	}
}
