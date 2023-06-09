Feature: Delete user

  Background:
    * url 'http://localhost:8081'
    * header Accept = 'application/json'
    * def deleteUserRequest = read ('../jsons/Mappings/jsonDeleteUserRequest.json')
    * def deleteUserResponse = read ('../jsons/Mappings/jsonDeleteUserResponse.json')

  Scenario: Delete existing user
    Given path '/user'
    And request deleteUserRequest
    When method DELETE
    Then status 201
    And match response.userName == deleteUserResponse.userName

  Scenario: Delete non existing user
    Given path '/user'
    And request deleteUserRequest
    When method DELETE
    Then status 404
    And match response == "User not found"

