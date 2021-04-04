package com.grover.imdb.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.grover.imdb.utils.Utils;

public class TopRatedMoviesPage {

	WebDriver driver;

	public TopRatedMoviesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text() = 'IMDb Charts']")
	WebElement imdbChartsTextEle;

	@FindBy(xpath = "//h1[text() = 'Top Rated Movies']")
	WebElement topRatedMoviesTextEle;

	@FindBy(xpath = "//label[text() = 'Sort by: ']")
	WebElement sortbyTextEle;

	@FindBy(xpath = "//select[@id='lister-sort-by-options']")
	WebElement sortbyDropDownEle;

	@FindBy(xpath = "//table[@class='chart full-width']/tbody/tr")
	List<WebElement> moviesListOptions;

	@FindBy(xpath = "//table[@class='chart full-width']/tbody")
	WebElement moviesList;

	@FindBy(xpath = "//nav[@id = 'imdbHeader']")
	WebElement navigationHeader;

	@FindBy(xpath = "//a[contains(text() ,' Western')]")
	WebElement westernGenreOption;

	public void selectSortingOption(String sortingOption) throws Exception {
		Select sel = new Select(sortbyDropDownEle);
		sel.selectByVisibleText(sortingOption);
		Utils.highLightElement(driver, sortbyDropDownEle);
	}

	public void verifyTopRatedPageUI() throws Exception {
		assertTrue(navigationHeader.isDisplayed());
		Utils.highLightElement(driver, navigationHeader);

		assertTrue(topRatedMoviesTextEle.isDisplayed());
		Utils.highLightElement(driver, topRatedMoviesTextEle);

		assertTrue(sortbyTextEle.isDisplayed());
		Utils.highLightElement(driver, sortbyTextEle);

		assertTrue(moviesList.isDisplayed());
		Utils.highLightElement(driver, moviesList);

		assertTrue(sortbyDropDownEle.isDisplayed());
		Utils.highLightElement(driver, sortbyDropDownEle);
	}

	public void verifyTopRatedPageLanding() throws Exception {
		assertTrue(driver.getTitle().equals("IMDb Top 250 - IMDb"));
		assertTrue(driver.getCurrentUrl().equals("https://www.imdb.com/chart/top"));
	}

	public void verifyMoviesCountAtLeastOne() throws Exception {
		verifyTopRatedPageUI();

		assertTrue(moviesListOptions.size() >= 1);
		assertTrue(moviesList.isDisplayed());
		Utils.highLightElement(driver, moviesList);
	}

	public void clickonWesternGenreLink() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", westernGenreOption);
		Utils.highLightElement(driver, westernGenreOption);
		
		westernGenreOption.click();
	}

}
