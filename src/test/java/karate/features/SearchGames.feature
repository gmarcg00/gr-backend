Feature: Searching games on navbar tool

  Background:
    * url 'http://localhost:8081'
    * header Accept = 'application/json'
    * def searchByRresponse = read ('../jsons/Mappings/jsonSearchGameByRprefixResponse.json')
    * def searchByReResponse = read ('../jsons/Mappings/jsonSearchGameByRePrefixResponse.json')

  Scenario Outline: Searching games
    Given path '/game/search/<prefix>'
    When method GET
    Then status <status>
    And match response == <gamesResponse>

    Examples:
      | prefix                | status | gamesResponse      |
      | r                     | 200    | searchByRresponse  |
      | re                    | 200    | searchByReResponse |
      | red dead redemption 2 | 200    | searchByReResponse |
      | Red dead rEdempTion 2 | 200    | searchByReResponse |
      | so                    | 204    | ''                 |