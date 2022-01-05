@echo off

SET WAR_NAME="TrainStationAdmin.war"
SET "WAR_LOCATION=target\%WAR_NAME%"

REM TOMCAT SETTINGS
SET TOMCAT_HOME=C:\apache\apache-tomcat-9.0.55-2
SET TOMCAT_PROJECT_LOCATION=%TOMCAT_HOME%\webapps
SET "TOMCAT_RUN_FILE=%TOMCAT_HOME%\bin\catalina.bat run"

D:
cd %PROJECT_ROOT%

call mvn clean package -DskipTests && ^
copy /Y %WAR_LOCATION% %TOMCAT_PROJECT_LOCATION%

if %errorlevel%==0 goto startTomcat
echo ERROR: tomcat can't start cause of errorlevel: %errorlevel%
goto endWithError

:startTomcat
C:
cd %TOMCAT_HOME%

call %TOMCAT_RUN_FILE%
goto end

:endWithError
SET /P msg="Press any key to continue ... "

:end