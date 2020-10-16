# Why another repository?

This repository showcases, by example, how to implement automated tests specified using cucumber-jvm and intelligently run them against
* Android
* iOS
* Browser

We will also integrate Applitools with this framework, to provide Visual AI testing as part of functional automation. 
## Tech stack used

* cucumber-jvm [https://cucumber.io]
* AppiumTestDistribution [] -> manages Android and iOS devices, and Appium
* Appium [https://appium.io]
* WebDriver [https://selenium.dev]

# Running the tests

`./gradlew cucumber`