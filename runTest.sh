#!/bin/bash

Xvfb :99 &
export local_addr="localhost:8080"


#/Katalon_Studio_Linux_64-5.7.1/katalon -noSplash  -runMode=console -projectPath="$(pwd)/PinaPollKatalon/PinaPollKatalon.prj" -retry=1 -testSuitePath="Test Suites/Register Test Suite" -executionProfile="default" -browserType="Chrome (headless)" -Djava.awt.headless

#/Katalon_Studio_Linux_64-5.7.1/katalon -noSplash  -runMode=console -projectPath="$(pwd)/PinaPollKatalon/PinaPollKatalon.prj" -retry=0 -testSuitePath="Test Suites/Register Test Suite" -executionProfile="default" -browserType="Chrome (headless)" -Djava.awt.headless

