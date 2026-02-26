@echo off
echo ========================================
echo Running tests...
echo ========================================
call mvn clean test

echo.
echo ========================================
echo Cleaning allure results...
echo ========================================
if exist "allure-results" (
    rmdir /s /q allure-results
    echo Deleted: allure-results folder
)

if exist "target\allure-results" (
    rmdir /s /q target\allure-results
    echo Deleted: target\allure-results folder
)

echo.
echo ========================================
echo Done! Tests completed and JSON cleaned.
echo ========================================
pause
