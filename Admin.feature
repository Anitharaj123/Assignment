Feature: login to salesforce application

Scenario: To get a list of admin certificates
Given Launch browser and enter url and maximize
And Enter username hari.radhakrishnan@qeagle.com
And Enter password Leaf@1234
When Click on Login 
And handling windows
And shadow element handling
Then Print the Admin Certificates in a List

