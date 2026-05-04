Feature: Login to HRM Application

	@validCredentials
	Scenario: Login with valid credentials
	
	 Given User is on Home page
	 When User enters uername as "Admin"
	 And User enters password as "admin123"
	 Then User should be able to login successfully