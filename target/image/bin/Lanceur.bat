@echo off
set JLINK_VM_OPTIONS=
set DIR=%~dp0
"%DIR%\java" %JLINK_VM_OPTIONS% -m com.mycompany.projetjavafx1/com.mycompany.projetjavafx1.App %*
