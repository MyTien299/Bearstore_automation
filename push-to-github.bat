@echo off
echo ========================================
echo Git Push to GitHub
echo ========================================

REM Check if git is initialized
if not exist ".git" (
    echo Initializing Git repository...
    git init
    git branch -M main
)

echo.
echo Adding all files...
git add .

echo.
set /p commit_msg="Enter commit message: "
git commit -m "%commit_msg%"

echo.
echo Pushing to GitHub...
git push -u origin main

echo.
echo ========================================
echo Done!
echo ========================================
pause
