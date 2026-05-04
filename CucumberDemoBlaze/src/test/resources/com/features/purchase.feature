Feature: Purchase

Background:
 Given User is on Home page


	@purchaseProduct
	Scenario: Successful product purchase
	
	 When User clicks "Samsung galaxy s6"
	 And User clicks "Add to cart"
	 Then pop up should appear with the message "Product added"
	 When User clicks "Cart"
	 And User clicks "Place Order"
	 Then fields should appear
	 When User enters name as "Jagadeep"
	 And User enters country as "India"
	 And User enters city as "Salem"
	 And User enters credit card as "6775433468"
	 And User enters month as "December"
	 And User enters year as "2026"
	 And User clicks "Purchase"
	 Then confirmation message "Thank you for your purchase!" should appear
	
	
	@emptyCartPurchase
	Scenario: Attempt purchase with empty cart
	
	 When User clicks "Cart"
	 Then the cart page should appear empty
	 When User clicks "Place Order"
	 Then purchase form should appear
	 When User clicks "Purchase"
	 Then purchase should not be completed
	
	
	@cancelPurchase
	Scenario: Cancel purchase process
	
	 When User clicks "Samsung galaxy s6"
	 And User clicks "Add to cart"
	 Then pop up should be appear with the message "Product added"
	 When User clicks "Cart"
	 And User clicks "Place Order"
	 Then purchase form should appear
	 When User clicks "Close"
	 Then purchase form should be closed
	 And user should remain on cart page