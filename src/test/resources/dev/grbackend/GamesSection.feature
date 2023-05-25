Feature: Games section

  Scenario Outline: Display games on games section
    Given a game review user
    When making click on games section
    Then info from game "<game>" will be displayed

    Examples:
      | game           |
      | The Last Of Us |
