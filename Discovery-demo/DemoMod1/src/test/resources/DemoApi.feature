Feature: Demo Api Behaviour

  Scenario: User wants to hit ping API
    Given The application is running
    When the user hit /ping api
    Then he will get the result "We are learing Spring Boot"

  Scenario: Breaker joins a game
    Given the Maker has started a game with the word "silky"
    When the Breaker joins the Maker's game
    Then the Breaker must guess a word with 5 characters