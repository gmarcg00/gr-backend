Feature:  Users testsuit

  Background:
    * url 'http://' + apphost + ':8081'
    * header Accept = 'application/json'
    * def getUsersResponse = read ('classpath:/jsons/Mappings/jsonGetUsersResponse.json')
    * def getSingleUserRequest = read ('classpath:/jsons/Mappings/jsonGetSingleUserRequest.json')
    * def getSingleUserResponse = read ('classpath:/jsons/Mappings/jsonGetSingleUserResponse.json')

  Scenario: testing get all users
    Given path '/user'
    When method GET
    Then status 200
    And match response == getUsersResponse

  Scenario: test get single user
    Given path '/user/login'
    And request getSingleUserRequest
    When method POST
    Then status 200
    And match response == getSingleUserResponse




