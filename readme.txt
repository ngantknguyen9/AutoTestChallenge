
######Automation Test Challenge:#########

###Provide the ONE XPath to return the requests which are submitted and approved in 2019 (Request Status = Approved && Date Submitted = 2019)
"//div[@class='react-bs-container-body']/table/tbody/tr/td[@class='td-request-approved uppercase']/../td[3]/div[contains(text(), '2019')]/parent::td/parent::tr"

### Write the automation script to verify for 
	Verify filter Student Access Request with INACTIVE
	Verify sorting of First Name column 
	The API endpoint - GET https://my-json-server.typicode.com/typicode/demo/posts/1

### Configure Java Project
It is recommended to edit the project by using Eclipse.

###### Run the Demo from the IDE
* Right Click on the /AutoTestChallenge/testsuite.xml file in the Project panel
* Click on Run 
