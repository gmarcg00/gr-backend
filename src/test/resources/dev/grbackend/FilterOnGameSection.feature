Feature: Games section

  Scenario Outline: Display games filtering by genre, platform and store on games section
    Given a game review user
    When filtering by genre "<genre>", platform "<platform>"
    Then the number of games returned will be <sizeList>
    And first game "<firstGame>" will be displayed
    Examples:
      | firstGame                  | genre                  | platform        | sizeList |
      | Grand Theft Auto V         | action                 |                 | 88       |
      | Grand Theft Auto V         | action                 | playstation5    | 9        |
      |                            | strategy               | xbox-series-x   | 0        |
      | Sid Meier's Civilization V | strategy               | pc              | 2        |
      | The Witcher 3: Wild Hunt   | role-playing-games-rpg | nintendo-switch | 6        |
