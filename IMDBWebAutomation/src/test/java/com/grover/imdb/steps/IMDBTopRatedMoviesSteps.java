package com.grover.imdb.steps;

import org.openqa.selenium.WebDriver;

import com.grover.imdb.pages.CommonComponents;
import com.grover.imdb.pages.TopRatedMoviesPage;
import com.grover.imdb.setup.SetUp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IMDBTopRatedMoviesSteps {

	WebDriver driver = SetUp.getDriver();
	TopRatedMoviesPage moviesPage = new TopRatedMoviesPage(driver);
	CommonComponents commonComponents = new CommonComponents(driver);

	@Given("User launches the IDMB application")
	public void user_launches_the_IDMB_application() throws Exception {
		commonComponents.lunchIDMBApp();
	}

	@When("User lands on top rated movies list page")
	public void user_lands_on_top_rated_movies_list_page() throws Exception {
		moviesPage.verifyTopRatedPageLanding();
	}

	@Then("Verify the UI for top rated movies list")
	public void verify_the_UI_for_top_rated_movies_list() throws Exception {
		moviesPage.verifyTopRatedPageUI();
	}

	@Then("Verify top rated movies count should be at least one movie in the list")
	public void verify_top_rated_movies_count_should_be_at_least_one_movie_in_the_list() throws Exception {
		moviesPage.verifyMoviesCountAtLeastOne();
	}

	@Then("User selects sorting option as (.*) from the sort by dropdown")
	public void user_selects_sorting_option_as_IMDb_Rating_from_the_sort_by_dropdown(String options) throws Exception {
		moviesPage.selectSortingOption(options);
	}

}
