# sqsproject

## required versions 

1. java - 8
2. maven 3.3.X
3. testng 3.9
4. Chrome, Internet Explorer or firefox browser

## How to build the project into local machine

1. First clone the project into IDE from GitHub using url https://github.com/sravangit/sqsproject.git
2. Import the project as Git -> Projects from Git -> Existing local repository -> select the cloned project
3 a sample video to clone the github repository into eclipse IDE https://www.youtube.com/watch?v=uOpug3ie_h0
4 if using chrome, internet explorer or firefox clear cache, sessions and cookies before running the tests
5. make sure to configure the project build path in the IDE as selecting the compiler as 'jdk <versionx>' instead jre under Build path -> Libraries

## to run a project from maven command
1. to run the test on chrome open config.properties file and change the browser=chrome or if IE then change browser=ie or if firefox change browser=firefox.
2. open command window and navigate to project root folder- for this project the root folder name is SQS_Project
3. run the maven command as "mvn -Ptest clean package"
4. the commonad window shows that the test is running
5. After the test is completed then the test results are stored in the html format in the folder SQS_Project\target\surefire-reports and the file name is index.html 
6. open the index.html file in any browser to see the test results.

## to run a project through eclipse maven
1. if incase after cloning and importing the project in the eclipse then there is a chance of missing 'Maven Dependency' in the project explorer view then the solution is to right click on the project folder select 'Maven' -> 'Select Maven Profiles..' -> in the Available profiles select 'test' and click Ok. you could see maven dependecy in the project explorer view.
2. update maven project by right click the project folder then select Maven -> Updated project...


## Note: steps if any one of these errors exists
1. if after running maven command 'mvn -Ptest clean package' shows any errors regarding any jars then delete .m2 folder in your machine completely and then run the command 'mvn -Ptest clean package' again.





