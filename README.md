===== Project Name ====== AutoHeroWebAutomation

===== Project Description =====
Writing the Automation Script for Hover And Get Details

===== Tools Using =====

Programming Language : Java(can be use the JDK above 5) Automation Tool : Selenium WebDriver 3.141.59 Framework Used : Hybrid Framework(BDD Cucumer, POM with Page Factory, Junit, Cucumber JVM Reports) Reports : Custom HTML reports Build Tool : Maven

===== How to Run =====

===== 1st Method =====

Run through Junit file : In the project root node there is a "TestRunner.java" file. Right click on it and choose run as then click on "JUnit Test" Option.

===== 2nd Method =====

Run through POM file : In the project root node there is a "pom.xml" file. Right click on it and choose run as then click on "mvn test" Option.

===== Reports Path =====

After completion of the script execution reports will be saved in "IMDBWebAutomation/target/cucumber-jvm-report/cucumber-html-report" folder.

===== How Framework Will Work ========

1. Once run the project through TestRunner.java or pom.xml file then control will move to feature file to read steps

2. After that control will move to step definitions package to read the glue code.

3. From step definitions control move to Page files to do actual test execution.

4. In the test base class we are maintaining the driver details and launching the browser.

5. Utils containing the utility method for the the project.

6. Configuration file having all the config details for the drivers, driver keys and reports path etc..

7. Finally reports will be stored under "IMDBWebAutomation/target/cucumber-jvm-report/cucumber-html-report" folder. Here we are using the cucumber JVM reports
