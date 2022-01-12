@echo off

SET "FOLDER_NAME=TrainStationAdmin"
SET "WAR_NAME=%FOLDER_NAME%.war"
SET "WAR_LOCATION=target\%WAR_NAME%"

REM TOMCAT SETTINGS
SET "TOMCAT_HOME=C:\apache\apache-tomcat-9.0.55-2"
SET "TOMCAT_PROJECT_LOCATION=%TOMCAT_HOME%\webapps"
SET "TOMCAT_OLD_FOLDER=%TOMCAT_PROJECT_LOCATION%\%FOLDER_NAME%"
SET "TOMCAT_RUN_FILE=%TOMCAT_HOME%\bin\catalina.bat run"

D:
cd %PROJECT_ROOT%

echo --
echo BUILDING MAVEN PROJECT . . .
echo --
call mvn clean package -DskipTests && ^

echo REMOVE OLD FOLDER: %TOMCAT_OLD_FOLDER% && ^
rmdir %TOMCAT_OLD_FOLDER% /S /Q && ^

echo COPY %WAR_LOCATION% to %TOMCAT_PROJECT_LOCATION% && ^
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