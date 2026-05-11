Feature: M_VIGNESHWARANN_5TH_MAY_QAFox_AddToCartFearure

	Background:
		Given the user launches the application
		
	@SearchAndAddToCart
	Scenario: Verify Add To Cart with valid search keys
	
	 Given the user enters the valid search key and give first product from the result Add To Cart
	 | macbook air |
	 | macbook pro | 
	 | iphone | 
	 When click cart button
	 Then the cart should display the added cart products
	 | macbook air | macbook pro | iphone | 