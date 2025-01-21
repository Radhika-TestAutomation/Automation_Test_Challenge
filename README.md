**BrandTrendingFollowers Test**
This repository contains automated tests for the BrandTrendingFollowers functionality using Selenium WebDriver and TestNG.

**Overview**
The test case verifies the follower count of the BabySam brand under the Child & Baby category in the "BRANDS" inspiration type. The test checks if the follower count is correctly displayed after logging into the website and navigating through various sections.

**Technologies Used:**
Selenium WebDriver: For automating browser interaction.
TestNG: For test execution and assertion.
Java: The primary programming language.
ChromeDriver: For running tests in the Chrome browser.

**Test Steps:**
Setup: The browser window is maximized, cookies are cleared, and an implicit wait of 20 seconds is set.
Navigate to Website: Opens the website specified in TestData.Website_Url, declines cookies if prompted.
Login: Logs in using credentials from TestData.USERNAME and TestData.PASSWORD.
Navigate to Inspiration Section: Clicks on the "Inspiration" tab and selects the "BRANDS" inspiration type.
Select Category: Selects the "Child & Baby" category.
Choose Brand: Clicks on the BabySam brand.
Check Followers: Navigates to the trending list, clicks the first trending item, and verifies the followers count is displayed correctly.
Assertion: Verifies the followers count is not null.

**Requirements**
Java 8 or higher
Chrome browser and ChromeDriver
Selenium WebDriver
TestNG

**Prerequisites**
Install Java and set up the environment variables.
Install ChromeDriver compatible with your version of Chrome.
Add the required dependencies to your pom.xml file for Maven or include them in your classpath.

**Authors**
Radhika Dhok
