package com.grover.imdb.pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Ordering;
import com.grover.imdb.utils.Utils;

public class WesternGenrePage {

	WebDriver driver;

	public WesternGenrePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//nav[@id = 'imdbHeader']")
	WebElement navigationHeader;

	@FindBy(xpath = "//div[@class='ratings-bar']/div/strong")
	List<WebElement> userRatingsList;

	@FindBy(xpath = "//h3[@class = 'lister-item-header']/a")
	List<WebElement> movieNamesList;

	@FindBy(xpath = "//p[@class='sort-num_votes-visible']/span[2]")
	List<WebElement> votesList;

	@FindBy(xpath = "//p[@class='sort-num_votes-visible']/span[5]")
	List<WebElement> boxOfficeRevenueList;

	@FindBy(xpath = "//h3[@class='lister-item-header']/span[2]")
	List<WebElement> moviesYearsList;

	@FindBy(xpath = "//h1[@class = 'header']")
	WebElement westernGenreHeaderText;

	@FindBy(xpath = "//a[text() = 'A-Z']")
	WebElement alphaOrderSortingOption;

	@FindBy(xpath = "//a[text() = 'Popularity']")
	WebElement popularitySortingOption;

	@FindBy(xpath = "//a[text() = 'User Rating']")
	WebElement userRatingSortingOption;
	
	@FindBy(xpath = "//strong[text() = 'User Rating']/..")
	WebElement userRatingSortingOption1;

	@FindBy(xpath = "//strong[text() = 'Number of Votes']/..")
	WebElement noOfVotesSortingOption1;

	@FindBy(xpath = "//a[text() = 'Number of Votes']")
	WebElement noOfVotesSortingOption;

	@FindBy(xpath = "//a[text() = 'US Box Office']")
	WebElement USBoxOfficeSortingOption;

	@FindBy(xpath = "//strong[text() = 'US Box Office']/..")
	WebElement USBoxOfficeSortingOption1;

	@FindBy(xpath = "//a[text() = 'Runtime']")
	WebElement runtimeSortingOption;

	@FindBy(xpath = "//strong[text() = 'Runtime']/..")
	WebElement runtimeSortingOption1;

	@FindBy(xpath = "//a[text() = 'Year']")
	WebElement yearSortingOption;

	@FindBy(xpath = "//strong[text() = 'Year']/..")
	WebElement yearSortingOption1;

	@FindBy(xpath = "//a[text() = 'Release Date']")
	WebElement releaseDateSortingOption;

	@FindBy(xpath = "//strong[text() = 'Release Date']/..")
	WebElement releaseDateSortingOption1;

	@FindBy(xpath = "//a[text() = 'Date of Your Rating']")
	WebElement dateOfYourRatingSortingOption;

	@FindBy(xpath = "//strong[text() = 'Date of Your Rating']/..")
	WebElement dateOfYourRatingSortingOption1;

	@FindBy(xpath = "//a[text() = 'Your Rating']")
	WebElement yourRatingSortingOption;

	@FindBy(xpath = "//strong[text() = 'Your Rating']/..")
	WebElement yourRatingSortingOption1;

	public void verifyWesternGenreLandingPage() throws Exception {
		assertTrue(driver.getTitle().contains("Western"));
		assertTrue(driver.getCurrentUrl().contains("genres=western"));

		assertTrue(navigationHeader.isDisplayed());
		Utils.highLightElement(driver, navigationHeader);
	}

	public void clickOnSortyByOption(String sortByOption) throws Exception {
		switch (sortByOption) {
		case "A-Z":
			assertTrue(alphaOrderSortingOption.isDisplayed());
			Utils.highLightElement(driver, alphaOrderSortingOption);
			alphaOrderSortingOption.click();

			break;

		case "User Rating":
			assertTrue(userRatingSortingOption1.isDisplayed());
			Utils.highLightElement(driver, userRatingSortingOption1);
			userRatingSortingOption1.click();
			Thread.sleep(3000);
			userRatingSortingOption1.click();

			break;

		case "Number of Votes":
			assertTrue(noOfVotesSortingOption.isDisplayed());
			Utils.highLightElement(driver, noOfVotesSortingOption);
			noOfVotesSortingOption.click();
			Thread.sleep(3000);
			noOfVotesSortingOption1.click();

			break;

		case "US Box Office":
			assertTrue(USBoxOfficeSortingOption.isDisplayed());
			Utils.highLightElement(driver, USBoxOfficeSortingOption);
			USBoxOfficeSortingOption.click();
			Thread.sleep(3000);
			USBoxOfficeSortingOption1.click();

			break;

		case "Run Time":
			assertTrue(runtimeSortingOption.isDisplayed());
			Utils.highLightElement(driver, runtimeSortingOption);
			runtimeSortingOption.click();
			Thread.sleep(3000);
			runtimeSortingOption1.click();

			break;

		case "Year":
			assertTrue(yearSortingOption.isDisplayed());
			Utils.highLightElement(driver, yearSortingOption);
			yearSortingOption.click();

			break;

		case "Release Date":
			assertTrue(releaseDateSortingOption.isDisplayed());
			Utils.highLightElement(driver, releaseDateSortingOption);
			releaseDateSortingOption.click();

			break;

		case "Date of Your Rating":
			assertTrue(dateOfYourRatingSortingOption.isDisplayed());
			Utils.highLightElement(driver, dateOfYourRatingSortingOption);
			dateOfYourRatingSortingOption.click();

			break;

		case "Your Rating":
			assertTrue(yourRatingSortingOption.isDisplayed());
			Utils.highLightElement(driver, yourRatingSortingOption);
			yourRatingSortingOption.click();
			Thread.sleep(3000);
			yourRatingSortingOption1.click();

			break;

		case "Popularity":
			assertTrue(popularitySortingOption.isDisplayed());
			Utils.highLightElement(driver, popularitySortingOption);
			popularitySortingOption.click();

			break;
		}
	}

	public void verifyWesternGenrePageAfterSort(String sortByOption) throws Exception {

		switch (sortByOption) {

		case "A-Z":
			assertTrue(driver.getTitle().contains("Sorted by Title Ascending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western&sort=alpha"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by Title Ascending"));
			Utils.highLightElement(driver, westernGenreHeaderText);

			ArrayList<String> moviesNames = new ArrayList<String>();
			Iterator<WebElement> itr = movieNamesList.iterator();
			while (itr.hasNext()) {
				WebElement webElement = (WebElement) itr.next();
				moviesNames.add(webElement.getText());
			}
			
			moviesNames.remove(0);
			System.out.println("======>>>> : "+moviesNames);
			assertFalse(Utils.stringsSorting(moviesNames));
			break;

		case "User Rating":
			assertTrue(driver.getTitle().contains("Sorted by IMDb Rating Descending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western&sort=user_rating"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by IMDb Rating Descending"));
			Utils.highLightElement(driver, westernGenreHeaderText);
			break;

		case "Number of Votes":
			assertTrue(driver.getTitle().contains("Sorted by Number of Votes Descending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western&sort=num_votes"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by Number of Votes Descending"));
			Utils.highLightElement(driver, westernGenreHeaderText);
			break;

		case "US Box Office":
			assertTrue(driver.getTitle().contains("Sorted by US Box Office Descending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western&sort=boxoffice_gross_us"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by US Box Office Descending"));
			Utils.highLightElement(driver, westernGenreHeaderText);
			break;

		case "Run Time":
			assertTrue(driver.getTitle().contains("Sorted by Runtime Descending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western&sort=runtime"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by Runtime Descending"));
			Utils.highLightElement(driver, westernGenreHeaderText);
			break;

		case "Year":
			assertTrue(driver.getTitle().contains("Sorted by Year Ascending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western&sort=year"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by Year Ascending"));
			Utils.highLightElement(driver, westernGenreHeaderText);
			break;

		case "Release Date":
			assertTrue(driver.getTitle().contains("Sorted by Release Date Ascending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western&sort=release_date"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by Release Date Ascending"));
			Utils.highLightElement(driver, westernGenreHeaderText);
			break;

		case "Date of Your Rating":
			assertTrue(driver.getTitle().contains("Sorted by Date of Your Rating Ascending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western&sort=your_rating_date"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by Date of Your Rating Ascending"));
			Utils.highLightElement(driver, westernGenreHeaderText);
			break;

		case "Your Rating":
			assertTrue(driver.getTitle().contains("Sorted by Your Rating Ascending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western&sort=my_ratings"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by Your Rating Ascending"));
			Utils.highLightElement(driver, westernGenreHeaderText);
			break;

		case "Popularity":
			assertTrue(driver.getTitle().contains("Sorted by Popularity Ascending"));
			assertTrue(driver.getCurrentUrl().contains("genres=western"));

			assertTrue(westernGenreHeaderText.isDisplayed());
			assertTrue(westernGenreHeaderText.getText().contains("Sorted by Popularity Ascending"));
			Utils.highLightElement(driver, westernGenreHeaderText);
			break;
		}
	}

}
