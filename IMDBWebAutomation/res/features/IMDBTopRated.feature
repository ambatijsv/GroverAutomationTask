Feature: IMDB Application RopRated Movies

  @imdb
  Scenario: Verify IMDB app top rated movies count should be at least one movie in the list
    Given User launches the IDMB application
    When User lands on top rated movies list page
    Then Verify the UI for top rated movies list
    And Verify top rated movies count should be at least one movie in the list

  @imdb
  Scenario Outline: Verify IMDB app top rated movies list with different sorting options
    Given User launches the IDMB application
    When User lands on top rated movies list page
    Then User selects sorting option as <sortingOption> from the sort by dropdown
    And Verify top rated movies count should be at least one movie in the list

    Examples: 
      | sortingOption     |
      | IMDb Rating       |
      | Ranking           |
      | Release Date      |
      | Number of Ratings |
      | Your Rating       |

  @imdb
  Scenario Outline: Verify each sorting options navigating to the Western genre page
    Given User launches the IDMB application
    When User lands on top rated movies list page
    And user click on Western genre link on right navigation options list
    Then user should land on Western Genre Page successfully
    Then User click on sorting by option as <sortingByOption> in the western Genre Page
    And vrify that movies details are load as per selected the option <sortingByOption>

    Examples: 
      | sortingByOption     |
      | A-Z                 |
      | User Rating         |
      | Number of Votes     |
      | US Box Office       |
      | Run Time            |
      | Year                |
      | Release Date        |
      | Date of Your Rating |
      | Popularity          |
