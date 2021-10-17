@echo off
echo [INFO] Please input new version:
set/p newVersion=
echo [INFO] The new version xxxx
call mvn clean versions:set -DnewVersion=%newVersion%
echo [INFO] Please check if xxxx is %newVersion%
pause
echo [INFO] Ready to commit
call mvn versions:commit
echo [INFO] End...
pause