@echo off
echo Compiling...
mkdir out
javac -d out src\snakefull\SnakeDeluxe.java
echo Creating JAR...
jar cfe SnakeDeluxe.jar snakefull.SnakeDeluxe -C out .
echo Done!
pause
