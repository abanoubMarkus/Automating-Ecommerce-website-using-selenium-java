@tag
  Feature: submit order from ecommerce website
    Background:

      Given I landed on Ecommerce page

    @tag2
      Scenario Outline: submitting order with Streams

      Examples:
       Given logged in with <name> and password <password>
        When i add product <product>
        When check out <product>
        Then message is displayed

        |name    |password   |product
        |abanoub@gmail.com|Abanoub123#|ADIDAS ORIGINAL
