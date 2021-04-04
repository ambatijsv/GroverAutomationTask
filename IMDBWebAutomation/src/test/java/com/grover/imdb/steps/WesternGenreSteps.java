package com.grover.imdb.steps;

import com.grover.imdb.pages.TopRatedMoviesPage;
import com.grover.imdb.pages.WesternGenrePage;
import com.grover.imdb.setup.SetUp;

import io.cucumber.java.en.Then;

public class WesternGenreSteps {

	TopRatedMoviesPage moviesPage = new TopRatedMoviesPage(SetUp.driver);
	WesternGenrePage westernGnrePage = new WesternGenrePage(SetUp.driver);

	@Then("user click on Western genre link on right navigation options list")
	public void user_click_on_Western_genre_link_on_right_navigation_options_list() throws Exception {
		moviesPage.clickonWesternGenreLink();
	}

	@Then("user should land on Western Genre Page successfully")
	public void user_should_land_on_Western_Genre_Page_successfully() throws Exception {
		westernGnrePage.verifyWesternGenreLandingPage();
	}

	@Then("User click on sorting by option as (.*) in the western Genre Page")
	public void user_click_on_sorting_by_option_in_the_western_Genre_Page(String sortByOption) throws Exception {
		westernGnrePage.clickOnSortyByOption(sortByOption);
	}

	@Then("vrify that movies details are load as per selected the option (.*)")
	public void vrify_that_movies_details_are_load_as_per_selected_the_option(String sortByOption) throws Exception {
		westernGnrePage.verifyWesternGenrePageAfterSort(sortByOption);
	}

}
