@echo off
echo Compiling Java files...
javac -cp . src/main/java/com/studentregistration/*.java -d target/classes
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b 1
)
echo Running the application...
java -cp target/classes com.studentregistration.Main
pause
