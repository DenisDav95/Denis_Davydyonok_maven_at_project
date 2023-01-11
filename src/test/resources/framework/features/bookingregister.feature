Feature: Booking register a new user

Scenario: I register a new user with confirmed email
Given I register a new user
When I confirm email address
When I login as user
Then I verify that mailbox was confirmed