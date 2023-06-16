## API testing 

The purpose of this document is to give more detailed information about how the API part of the testing was done.
As in other parts of the final assignment, the item under test was the PlaceLab module called Road Analysis.
The task consisted of the following:


Postman collection was created in order to test the Road Analysis module of the PlaceLab application. Using the documentation available on the PlaceLab application, API tests were created.

## Given-When-Then format


Following Given-When-Then format, smoke test can be represented in this way:

Given: the user obtains an authentication token by entering a valid email and password.

When: user has authentication token, he is able to upload file for Road analysis report to and to create the report.

Then: when user creates report, specific ID is represented in response

And: user is able to obtain report status.

And: user is able to download the result file.
