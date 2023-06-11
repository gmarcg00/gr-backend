Feature: Filter on search bar

  Scenario Outline: Display games filtering by name
    Given a game review user
    When searching by name "<prefix>" on the search bar
    Then the number of games returned will be <sizeList>
    And game "<firstGame>" will be displayed in first position
      Examples:
      | firstGame                        | prefix | sizeList |
      | Apex Legends                     | a      | 4        |
      | Assassin’s Creed IV: Black Flag  | as     | 1        |
      | BioShock Infinite                | b      | 5        |
      | BioShock Infinite                | bi     | 4        |
      | Counter-Strike: Global Offensive | c      | 5        |
      | Counter-Strike: Global Offensive | co     | 5        |
      | Control                          | con    | 1        |