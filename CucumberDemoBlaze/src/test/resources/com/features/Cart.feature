Feature: Cart

Background:
	 Given User is on Home page

	@addToCart
	Scenario: Visibility of products in cart
	 
	 When User clicks  "Samsung galaxy s6"
	 Then the product page appears with product details
	 When User clicks "Add to cart"
	 Then pop up should appear with the message "Product added"
	 
	 @checkCart
	 Scenario: Visibility of products in cart
	
	 When User clicks  "Cart"
	 Then the cart page should appear with the list products that added to cart
	 
	 @removeFromCart
	 Scenario: Remove items from cart
	 
	 Given User is on cart page
	 When User clicks "delete" in a item named "Samsung galaxy s6"
	 Then the item should be removed from the cart

	 
	 