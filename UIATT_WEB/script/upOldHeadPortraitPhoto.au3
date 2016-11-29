;ControlFocus("title","text",controlID) Edit1=Edit instance 1
ControlFocus("打开", "","Edit1")

; Set the File name text on the Edit field
 If Not WinActivate("[CLASS:#32770]", "") Then WinActivate("[CLASS:#32770]", "")
   ; Wait 10 seconds for the Upload window to appear
  WinWaitActive("[CLASS:#32770]", "",10)
  ControlSetText("打开", "", "Edit1", "D:\MarsWorkspace\allinmdPCAuto1\data\OLDHEADPHOTO.jpg")

  Sleep(2000)

; Click on the Open button
If Not WinActivate("[CLASS:#32770]", "") Then WinActivate("[CLASS:#32770]", "")
   ; Wait 10 seconds for the Upload window to appear
  WinWaitActive("[CLASS:#32770]", "",10)
  ControlClick("打开", "","Button1");