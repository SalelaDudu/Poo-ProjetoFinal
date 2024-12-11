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

del /q *.class

exit