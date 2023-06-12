Feature: Get user reactions

  Scenario Outline: a game review user accesses to his account
    Given a game review user
    When user "<userName>" checks his liked games
    Then <sizeList> games that "<userName>" has liked appears on user games section
    Examples:
      | userName | sizeList |
      | user1    | 2        |
      | user2    | 1        |
