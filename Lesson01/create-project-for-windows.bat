@echo off
REM Script tao project Java co ban cho Windows va tu dong bien dich

:NHAP_DUONG_DAN
set /p projectpath=Nhap duong dan luu project (vi du: D:\Module02_HungNX): 
if "%projectpath%"=="" (
    echo.
    echo LOI: Duong dan luu project khong duoc de trong.
    goto NHAP_DUONG_DAN
)

:NHAP_TEN_PROJECT
echo.
set /p projectname=Nhap ten project: 

REM Kiem tra neu ten project bi bo trong
if "%projectname%"=="" (
    echo.
    echo LOI: Ten project khong duoc de trong.
    goto NHAP_TEN_PROJECT
)

set fullpath="%projectpath%\%projectname%"

REM Kiem tra xem thu muc project da ton tai chua
if exist %fullpath% (
    echo.
    echo LOI: Thu muc project "%projectname%" da ton tai tai "%projectpath%"!
    echo Vui long nhap ten project khac.
    goto NHAP_TEN_PROJECT
)

REM --- Bat dau tao Project ---
echo.
echo Kiem tra hop le: OK. Bat dau tao project...

REM Tao cac thu muc
mkdir %fullpath%
mkdir %fullpath%\src
mkdir %fullpath%\bin
mkdir %fullpath%\lib
mkdir %fullpath%\.vscode

REM Tao file settings.json cho VS Code
echo {> %fullpath%\.vscode\settings.json
echo     "java.project.sourcePaths": ["src"],>> %fullpath%\.vscode\settings.json
echo     "java.project.outputPath": "bin",>> %fullpath%\.vscode\settings.json
echo     "java.project.referencedLibraries": [>> %fullpath%\.vscode\settings.json
echo         "lib/**/*.jar" >> %fullpath%\.vscode\settings.json
echo     ]>> %fullpath%\.vscode\settings.json
echo }>> %fullpath%\.vscode\settings.json

REM Tao file Main.java mau
echo public class Main {> %fullpath%\src\Main.java
echo     public static void main(String[] args) {>> %fullpath%\src\Main.java
echo         System.out.println("Hello, %projectname%!");>> %fullpath%\src\Main.java
echo     }>> %fullpath%\src\Main.java
echo }>> %fullpath%\src\Main.java

echo.
echo =======================================================
echo DA TAO THANH CONG PROJECT %projectname%
echo Duong dan: "%projectpath%\%projectname%"
echo File Main.java mau da san sang trong thu muc src.
echo Mo thu muc nay trong VS Code de bat dau lap trinh.
echo =======================================================
pause