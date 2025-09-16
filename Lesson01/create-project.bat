@echo off
REM Script tao project Java co ban va tu dong bien dich file .java moi
set /p projectpath=Nhap duong dan luu project (vi du: D:\Module02_HungNX): 
set /p projectname=Nhap ten project: 
set fullpath=%projectpath%\%projectname%
md "%fullpath%\src"
md "%fullpath%\bin"
md "%fullpath%\lib"
md "%fullpath%\.vscode"
echo public class HelloWorld {> "%fullpath%\src\HelloWorld.java"
echo.    public static void main(String[] args) {>> "%fullpath%\src\HelloWorld.java"
echo.        System.out.println("Hello, World!");>> "%fullpath%\src\HelloWorld.java"
echo.    }>> "%fullpath%\src\HelloWorld.java"
echo }>> "%fullpath%\src\HelloWorld.java"
echo {> "%fullpath%\.vscode\settings.json"
echo     "java.project.sourcePaths": ["src"],>> "%fullpath%\.vscode\settings.json"
echo     "java.project.outputPath": "bin",>> "%fullpath%\.vscode\settings.json"
echo     "java.project.referencedLibraries": [>> "%fullpath%\.vscode\settings.json"
echo         "lib/**/*.jar" >> "%fullpath%\.vscode\settings.json"
echo     ]>> "%fullpath%\.vscode\settings.json"
echo }>> "%fullpath%\.vscode\settings.json"
REM Tu dong bien dich tat ca file .java moi trong src moi 60 giay
:loop
echo Dang bien dich tat ca file .java trong src ...
javac -d "%fullpath%\bin" "%fullpath%\src\*.java"
echo Da bien dich xong. Se kiem tra lai sau 60 giay ...
choice /t 60 /d y >nul
goto loop