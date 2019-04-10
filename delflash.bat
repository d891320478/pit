@echo off
taskkill /f /t /im FlashHelperService.exe
ping 127.0.0.1
del /f /s /q "C:\Windows\SysWOW64\Macromed\Flash\FlashHelperService.exe"
Reg delete "HKEY_LOCAL_MACHINE\SOFTWARE\Wow6432Node\Microsoft\Internet Explorer\MAIN\FeatureControl\FEATURE_BROWSER_EMULATION" /v "FlashHelperService" /f
Reg delete "HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\services\Flash Helper Service" /f
Reg delete "HKEY_LOCAL_MACHINE\SYSTEM\ControlSet002\services\Flash Helper Service" /f
pause
