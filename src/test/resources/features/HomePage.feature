@regression @homepage


Feature: Homepage Features

Given I am on the home page

  @homepage-1
  Scenario: Verify auto complete search result
    When  I search on top search bar with text ios
    Then  I verify Title: I will teach you IOS as displayed result


  @homepage-2
  Scenario: Verify total number of posts on home page
    Then I verify 56 total post is displayed
    And  I verify all post has price tag
    And  I verify all post has title
    And  I verify all post has displayed image