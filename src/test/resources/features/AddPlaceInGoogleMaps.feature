Feature: Add plan in google maps

  @demoTest
  @addPlace
  Scenario Outline: add a new place to the google maps
    Given user has the details of new place to be added in google maps
      | accuracy   | name   | phoneNumber   | address   | website   | language   | latitude   | longitude   | types   |
      | <accuracy> | <name> | <phoneNumber> | <address> | <website> | <language> | <latitude> | <longitude> | <types> |
    When user "adds" the place
    Then the place is "added" "to" the google maps

    Examples:
      | accuracy | name            | phoneNumber        | address                   | website             | language  | latitude   | longitude | types          |
      | 50       | Frontline house | (+91) 123 456 7890 | 29, side layout, cohen 09 | www.example.com     | French-IN | -38.383494 | 33.427362 | shoe park_shop |
      | 40       | Backline house  | (+91) 456 456 7890 | 99, main layout, cohen 29 | www.new.example.com | Dutch-IN  | -40.383494 | 40.427362 | park_shop      |