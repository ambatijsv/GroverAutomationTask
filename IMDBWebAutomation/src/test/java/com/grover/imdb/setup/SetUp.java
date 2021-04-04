package com.grover.imdb.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.grover.imdb.config.Config;

public class SetUp {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		System.setProperty(Config.CHROME_DRIVER_KEY, Config.Chrome_Driver_Path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
