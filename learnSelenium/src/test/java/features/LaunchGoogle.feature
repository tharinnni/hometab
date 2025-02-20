Feature: Check google

Scenario Outline: launch google and search hi

Given launch google chrome
And open google search engine
And in searchbox type <text>
And click on search button
Then verify the results

Examples:
|text|
|Hi|

