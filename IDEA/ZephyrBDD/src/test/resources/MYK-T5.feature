Feature: Add item to cart
    @TestCaseKey=MYK-T5
    Scenario: Add item to cart
        
        An a user, I want to add item to cart so that i can purchare them
        
        Given user opened cart page
        When User added item to cart 
        Then number or item in cart to changes
        And total price is correctly