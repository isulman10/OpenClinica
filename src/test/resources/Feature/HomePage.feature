Feature: Google Search

Scenario: user search with specific word

Given user is on home page and validate title "Google"
Then user validate the logo
Then user click on search bar and type "search terms"
And user check the title of the page "search terms - Google Search"



Scenario: user click on search without entering anything in Search bar

Given user is on home page and validate title "Google"
Then user verify that the search button is enable 
Then user click on search button without entering anything
