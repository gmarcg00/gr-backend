Feature: Delete user

  Background:
    * url 'http://localhost:8081'
    * header Accept = 'application/json'
    * def deleteUserRequest = read ('../jsons/Mappings/jsonDeleteUserRequest.json')
    * def deleteUserResponse = read ('../jsons/Mappings/jsonDeleteUserResponse.json')

  Scenario: Delete user
    Given path '/user'
    And request deleteUserRequest
    When method DELETE
    Then status 201
    And match response.email == deleteUserResponse.email
    And match response.userName == deleteUserResponse.userName
    And match response.password == deleteUserResponse.password
