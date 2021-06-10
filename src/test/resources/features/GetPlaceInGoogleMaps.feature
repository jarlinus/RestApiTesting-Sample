Feature: Fetch the place in google maps

  @demoTest
  @fetchPlace
  Scenario: fetch a place in the google maps
    Given user has the details of new place to be added in google maps
      | accuracy | name            | phoneNumber        | address                   | website         | language  | latitude   | longitude | types          |
      | 50       | Frontline house | (+91) 123 456 7890 | 29, side layout, cohen 09 | www.example.com | French-IN | -38.383494 | 33.427362 | shoe park_shop |
    When user "adds" the place
    Then the place is "added" "to" the google maps
    When user "gets" the place
    Then the place is "fetched" "from" the google maps
