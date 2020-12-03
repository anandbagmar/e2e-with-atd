# Why another repository?

This repository showcases, by example, how to implement automated tests specified using cucumber-jvm and intelligently run them against
* Android
* iOS
* Browser

We will also integrate Applitools with this framework, to provide Visual AI testing as part of functional automation.

# What is this repository about?

This repository implements automated tests for JioMeet, specified using cucumber-jvm and intelligently run them against
* Android
* iOS
* Browser

We will also integrate Applitools with this framework, to provide Visual AI testing as part of functional automation.

Reports will be uploaded to reportportal. 
 
## Tech stack used

* cucumber-jvm (https://cucumber.io)
* AppiumTestDistribution (https://github.com/AppiumTestDistribution/AppiumTestDistribution) -> manages Android and iOS devices, and Appium
* Appium (https://appium.io)
* WebDriver (https://selenium.dev)
* reportportal.io (https://reportportal.io)
* Applitools (https://applitools.com)

# Prerequisites

* Install JDK and set JAVA_HOME
* Setup Android Command-line tools and SDK
* Install appium
* To verify appium installation is successful, run 
    `appium-doctor` - it should not report any errors
* Install reportportal (Docker setup is the easiest way to proceed: https://reportportal.io/installation)
* The tests run against the vodQA app. You can download it from the blow links and place it in the temp directory for the test to pick it up automatically. Alternatively, you can provide the below mentioned links in the caps/capabilities.json file
    * Android: https://github.com/shridharkalagi/AppiumSample/raw/master/VodQA.apk 
    * iOS: https://github.com/saikrishna321/AppiumTestDistribution/blob/master/apps/VodQAReactNative.zip?raw=true
 
# Running the tests

`./gradlew cucumber`

# Configurations

`Visual=true Platform=android Threads=2 ./gradlew cucumber`
The above command will run the tests against connected Android devices, with 2 tests running in parallel and Applitools Visual Testing enabled

## Default configuration

* Platform=android
* Threads=1
* Visual=false