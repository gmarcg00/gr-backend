Feature: Login user

  Background:
    * url 'http://localhost:8081'
    * header Accept = 'application/json'
    * def singleUserRequest = read ('../jsons/Mappings/jsonSingleUserRequest.json')
    * def nonExistentUserRequest = read ('../jsons/Mappings/jsonNonExistentUserRequest.json')
    * def SingleUserResponse = read ('../jsons/Mappings/jsonSingleUserResponse.json')


  Scenario Outline: Login user
    Given path '/user/login'
    And request <request>
    When method POST
    Then status <status>
    And match response == <response>

    Examples:
      | request                | status | response                                |
      | singleUserRequest      | 200    | SingleUserResponse                      |
      | nonExistentUserRequest | 401    | "User not found or invalid credentials" |