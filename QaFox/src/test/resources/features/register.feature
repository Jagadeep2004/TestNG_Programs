Feature: M_VIGNESHWARANN_5TH_MAY_QAFox_RegisterFearure

	Background:
		Given the user launches the application
		
	@ValidRegistration
	Scenario: Verify registration with valid credentials
	
	 Given the user is on register page
	 When the user enters the valid cedentials
	 | Vignesh | M | vigneshwaran.coder@gmail.com2 | 1234567890 | 1234 | 1234 | 
	 And click continue
	 Then the greet message should appear as "Your Account Has Been Created!";