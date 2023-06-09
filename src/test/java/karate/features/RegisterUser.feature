Feature: Register user

  Background:
    * url 'http://localhost:8081'
    * header Accept = 'application/json'
    * def createUserRequest = read ('../jsons/Mappings/jsonCreateUserRequest.json')
    * def createUserResponse = read ('../jsons/Mappings/jsonCreateUserResponse.json')

  Scenario: Register user with correct credentials
    Given path '/user/register'
    And request createUserRequest
    When method POST
    Then status 201
    And match response.email == createUserResponse.email
    And match response.userName == createUserResponse.userName
    And match response.password == createUserResponse.password

  Scenario: Register user with not available user name
    Given path '/user/register'
    And request createUserRequest
    When method POST
    Then status 409
    And match response == "User name already used"