# HeyGirl
Fork from BaiduSecurityLabs/ZjDroid.

# Reference
[BaiduSecurityLabs/ZjDroid](http://seclab.safe.baidu.com/opensec_detail_2.html)

[The ZjDroid Author Blog](http://blog.csdn.net/androidsecurity/article/details/38121585)

# Changes
Migrating the original project to Android Studio.
Changing the `com.zjdroid.invoke` action to `hey.girl`.

# Command
## 1、Dump dex information
`adb shell am broadcast -a hey.girl --ei target [pid] --es cmd '{"action":"dump_dexinfo"}'`
 
## 2、Dump dex classes
`adb shell am broadcast -a hey.girl --ei target [pid] --es cmd '{"action":"dump_class","dexpath":"*****"}'`
 
## 3、Dump dex
`adb shell am broadcast -a hey.girl --ei target [pid] --es cmd '{"action":"dump_dex","dexpath":"*****"}'`
 
## 4、Dump dex by baksmali
`adb shell am broadcast -a hey.girl --ei target [pid] --es cmd '{"action":"baksmali","dexpath":"*****"}'`
 
## 5、Dump memory
`adb shell am broadcast -a hey.girl --ei target [pid] --es cmd '{"action":"dump_mem","start":1234567,"length":123}'`
 
## 6、Dump stack trace information.                                                                                                                                                              
`adb shell am broadcast -a hey.girl --ei target [pid] --es cmd '{"action":"dump_heap"}'`
 
## 7、Run Lua script.
`adb shell am broadcast -a hey.girl --ei target [pid] --es cmd '{"action":"invoke","filepath":"****"}'`
