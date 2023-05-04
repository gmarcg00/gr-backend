Feature:  Users testsuit

  Background:
    * url 'http://localhost:8081'
    * header Accept = 'application/json'
    * def getUsersResponse = read ('../jsons/Mappings/jsonGetUsersResponse.json')
    * def getSingleUserRequest = read ('../jsons/Mappings/jsonGetSingleUserRequest.json')
    * def getSingleUserResponse = read ('../jsons/Mappings/jsonGetSingleUserResponse.json')
    * def createUserRequest = read ('../jsons/Mappings/jsonCreateUserRequest.json')
    * def createUserResponse = read ('../jsons/Mappings/jsonCreateUserResponse.json')
    * def getUsersResponseAfterPost = read ('../jsons/Mappings/jsonGetUsersResponseAfterPost.json')
    * def deleteUserRequest = read ('../jsons/Mappings/jsonDeleteUserRequest.json')
    * def deleteUserResponse = read ('../jsons/Mappings/jsonDeleteUserResponse.json')

  Scenario: testing get all users
    Given path '/user'
    When method GET
    Then status 200
    And match response == getUsersResponse

  Scenario: testing get single user
    Given path '/user/login'
    And request getSingleUserRequest
    When method POST
    Then status 200
    And match response == getSingleUserResponse

  Scenario: testing create user
    Given path '/user/register'
    And request createUserRequest
    When method POST
    Then status 200

 Scenario: testing delete user
   Given path '/user'
   And request deleteUserRequest
   When method DELETE
   Then status 201
   And match response == deleteUserResponse


