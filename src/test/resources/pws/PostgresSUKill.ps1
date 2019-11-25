Start-Process "$psHome\powershell.exe" -Verb Runas -ArgumentList ("cmd.exe /c 'taskkill /IM postgres.exe' /T /F")
