Start-Process "$psHome\powershell.exe" -Verb Runas -ArgumentList ("cmd.exe /c 'sc start ArmadaSU' /T /F")
