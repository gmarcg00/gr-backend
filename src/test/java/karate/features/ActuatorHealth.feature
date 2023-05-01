Feature: ACTUATOR-HEALTH testsuite

  Background:
    * url 'http://' + apphost + ':8081'
    * header Accept = 'application/json'

  Scenario: testing health status gr-backend
    Given path '/actuator/health'
    When method GET
    Then status 200
    And match response.status == 'UP'