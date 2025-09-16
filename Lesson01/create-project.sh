#!/bin/bash
# Script tao project Java co ban va tu dong bien dich file .java moi tren macOS/Linux
read -p "Nhap duong dan luu project (vi du: /Users/tenuser/JavaProjects): " projectpath
read -p "Nhap ten project: " projectname
fullpath="$projectpath/$projectname"
mkdir -p "$fullpath/src" "$fullpath/bin" "$fullpath/lib" "$fullpath/.vscode"
cat << EOF > "$fullpath/src/HelloWorld.java"
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
EOF
cat << EOF > "$fullpath/.vscode/settings.json"
{
    "java.project.sourcePaths": ["src"],
    "java.project.outputPath": "bin",
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
EOF
echo "Da tao project $projectname tai $fullpath voi src, bin, lib, .vscode/settings.json va HelloWorld.java."
echo "Tu dong bien dich tat ca file .java trong src moi 60 giay."
while true; do
    echo "Dang bien dich tat ca file .java trong src ..."
    javac -d "$fullpath/bin" "$fullpath/src"/*.java
    echo "Da bien dich xong. Se kiem tra lai sau 60 giay ..."
    sleep 60
done
