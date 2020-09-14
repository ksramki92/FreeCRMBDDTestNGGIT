Feature: Free CRM Login feature file

Scenario Outline: Free CRM Login Test
Given User is already on login page
When Title of the page is Free CRM
Then User enters "<username>" and "<password>"
Then User is on home page
Then User verifies the username
Then User logs out
Examples:
|username				|	password	|
|ksramki92@gmail.com	|	Yourwish@18 |