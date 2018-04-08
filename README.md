#ProcStartTest
This two apks are used to test the situations of proc_start.
Usage:
1)Before test, use command: adb logcat -c and adb logcat|grep "ProcStartTest"
2)Then launch ProcStartTest.apk, by observing log, you can see one process with exact pid has been lauched.
3)Launch SendBroadCast.apk and press button,  broadcast will be sent to start service process, which activates the situation of "ProcStartTest"
