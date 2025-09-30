#!/bin/bash
# Script tao project Java co ban cho macOS/Linux

# Vong lap de nhap duong dan (chac chan khong bi de trong)
while true; do
    read -p "Nhap duong dan luu project (vi du: $HOME/JavaProjects): " projectpath
    if [ -z "$projectpath" ]; then
        echo ""
        echo "LOI: Duong dan luu project khong duoc de trong."
    else
        break # Thoat vong lap neu duong dan hop le
    fi
done

# Vong lap de nhap ten project (chac chan khong bi trung)
while true; do
    echo ""
    read -p "Nhap ten project: " projectname

    # Kiem tra neu ten project bi bo trong
    if [ -z "$projectname" ]; then
        echo ""
        echo "LOI: Ten project khong duoc de trong."
        continue # Quay lai dau vong lap
    fi

    fullpath="$projectpath/$projectname"

    # Kiem tra xem thu muc project da ton tai chua
    if [ -d "$fullpath" ]; then
        echo ""
        echo "LOI: Thu muc project '$projectname' da ton tai tai '$projectpath'!"
        echo "Vui long nhap ten project khac."
        continue # Quay lai dau vong lap
    else
        break # Thoat vong lap neu ten project hop le
    fi
done

# --- Bat dau tao Project ---
echo ""
echo "Kiem tra hop le: OK. Bat dau tao project..."

# Tao cac thu muc (su dung -p de tao ca thu muc cha neu can)
mkdir -p "$fullpath/src" "$fullpath/bin" "$fullpath/lib" "$fullpath/.vscode"

# Tao file settings.json cho VS Code (su dung Heredoc)
cat << EOF > "$fullpath/.vscode/settings.json"
{
    "java.project.sourcePaths": ["src"],
    "java.project.outputPath": "bin",
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
EOF

# Tao file Main.java mau
cat << EOF > "$fullpath/src/Main.java"
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, $projectname!");
    }
}
EOF

echo ""
echo "======================================================="
echo "DA TAO THANH CONG PROJECT $projectname"
echo "Duong dan: $fullpath"
echo "File Main.java mau da san sang trong thu muc src."
echo "Mo thu muc nay trong VS Code de bat dau lap trinh."
echo "======================================================="