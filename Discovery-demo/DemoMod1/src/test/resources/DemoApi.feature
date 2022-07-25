Feature: Demo Api Behaviour

  Scenario: User wants to hit ping API
    Given The application is running
    When the user hit /ping api
    Then he will get the result "We are learing Spring Boot"

