call runcrud.bat
if "%ERRORLEVEL%" == "0" goto showTasks
echo.
echo Runcrud has errors - breaking work
goto fail

:showTasks
echo.
call "C:\Program Files\Mozilla Firefox\firefox.exe" http://localhost:8080/crud/v1/task/getTasks
echo Tasks are shown.
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.