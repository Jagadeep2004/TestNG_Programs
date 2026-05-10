Feature: M_VIGNESHWARANN_5TH_MAY_QAFox_LoginFearure

	Background:
		Given the user launches the application
		
	@ValidLogin
	Scenario Outline: Verify login with valid credentials
	
	 Given the user is on login page
	 When the user enters the valid email as "<email>"
	 When the user enters the valid password as "<password>"
	 And click login
	 Then the link should appear as "<linkText>";
	 
	 Examples:
	 | email                        | password | linkText                      |
	 | vigneshwaran.coder@gmail.com | 1234     | Edit your account information |
	 | vigneshwaran.coder@gmail.com1 | 1234     | Edit your account information |