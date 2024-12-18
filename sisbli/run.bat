@echo off

echo Compilando...

javac Principal.java

if %ERRORLEVEL% neq 0 (
    echo Erro na compilação!
    pause
    exit /b %ERRORLEVEL%
)

echo Executando...
java Principal

echo Limpando arquivos .class...
for /r %%f in (*.class) do (
    del /q "%%f"
)

exit
