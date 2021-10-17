echo "start deploy xxx...."
call mvn clean deploy -Dmaven.test.skip=true -P release
echo "deploy finished."
pause