Feature:  Games testsuit

  Background:
    * url 'http://' + apphost + ':8081'
    * header Accept = 'application/json'
    * def getGamesResponse = read ('classpath:/jsons/Mappings/jsonGetGamesResponse.json')
    * def createGameRequest = read ('classpath:/jsons/Mappings/jsonCreateGameRequest.json')

  Scenario: testing get all games
    Given path '/game'
    When method GET
    Then status 200
    And match response == getGamesResponse

 # Scenario: create game
 #   Given path '/game'
 #   And request createGameRequest
 #   When method POST
 #   Then status 200
 #   And match response.slug == "the-legend-of-zelda"
 #   And match response.playtime == 3