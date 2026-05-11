Feature: Login to HRM Application

	@validCredentials
	Scenario: Login with valid credentials
	
	Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
	When User enters username and password
	Then User should be able to login successfully and should see Dashboard
	
	@invalidCredentials
	Scenario: Login with invalid credentials
	
	Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
	When User enters username and password
	Then User should not be able to login successfully and should not see Dashboard