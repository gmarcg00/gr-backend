Feature: Login user

  Background:
    * url 'http://localhost:8081'
    * header Accept = 'application/json'
    * def singleUserRequest = read ('../jsons/Mappings/jsonSingleUserRequest.json')
    * def wrongUserNameUserRequest = read ('../jsons/Mappings/jsonWrongUserNameUserRequest.json')
    * def wrongPasswordUserRequest = read ('../jsons/Mappings/jsonWrongPasswordUserRequest.json')
    * def singleUserResponse = read ('../jsons/Mappings/jsonSingleUserResponse.json')


  Scenario Outline: Login user - <description>
    Given path '/user/login'
    And request <request>
    When method POST
    Then status <status>
    And match response == <response>

    Examples:
      | description         | request                  | status | response              |
      | correct credentials | singleUserRequest        | 200    | singleUserResponse    |
      | incorrect username  | wrongUserNameUserRequest | 401    | "Invalid credentials" |
      | incorrect password  | wrongPasswordUserRequest | 401    | "Invalid credentials" |
