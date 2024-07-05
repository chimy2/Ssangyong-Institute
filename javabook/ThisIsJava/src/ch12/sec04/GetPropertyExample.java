package ch12.sec04;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
	public static void main(String[] args) {
//		운영체제와 사용자 정보 출력
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		System.out.println(osName);
		System.out.println(userName);
		System.out.println(userHome);
		
//		전체 키와 값을 출력
		System.out.println("------------------------");
		System.out.println(" key:     value");
		System.out.println("------------------------");
		Properties props = System.getProperties();
		Set keys = props.keySet();
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.printf("%-40s: %s\n", key, value);
		}
		/*
		Windows 11
		user
		C:\Users\user
		------------------------
		 key:     value
		------------------------
		sun.desktop                             : windows
		awt.toolkit                             : sun.awt.windows.WToolkit
		java.specification.version              : 11
		sun.cpu.isalist                         : amd64
		sun.jnu.encoding                        : MS949
		java.class.path                         : C:\class\code\javabook\ThisIsJava\bin
		java.vm.vendor                          : Oracle Corporation
		sun.arch.data.model                     : 64
		user.variant                            : 
		java.vendor.url                         : https://openjdk.java.net/
		user.timezone                           : 
		os.name                                 : Windows 11
		java.vm.specification.version           : 11
		sun.java.launcher                       : SUN_STANDARD
		user.country                            : KR
		sun.boot.library.path                   : C:\class\dev\jdk-11\bin
		sun.java.command                        : ch12.sec04.GetPropertyExample
		jdk.debug                               : release
		sun.cpu.endian                          : little
		user.home                               : C:\Users\user
		user.language                           : ko
		java.specification.vendor               : Oracle Corporation
		java.version.date                       : 2024-01-16
		java.home                               : C:\class\dev\jdk-11
		file.separator                          : \
		java.vm.compressedOopsMode              : Zero based
		line.separator                          : 

		java.specification.name                 : Java Platform API Specification
		java.vm.specification.vendor            : Oracle Corporation
		java.awt.graphicsenv                    : sun.awt.Win32GraphicsEnvironment
		user.script                             : 
		sun.management.compiler                 : HotSpot 64-Bit Tiered Compilers
		java.runtime.version                    : 11.0.22+9-LTS-219
		user.name                               : user
		path.separator                          : ;
		os.version                              : 10.0
		java.runtime.name                       : Java(TM) SE Runtime Environment
		file.encoding                           : UTF-8
		java.vm.name                            : Java HotSpot(TM) 64-Bit Server VM
		java.vendor.version                     : 18.9
		java.vendor.url.bug                     : https://bugreport.java.com/bugreport/
		java.io.tmpdir                          : C:\Users\user\AppData\Local\Temp\
		java.version                            : 11.0.22
		user.dir                                : C:\class\code\javabook\ThisIsJava
		os.arch                                 : amd64
		java.vm.specification.name              : Java Virtual Machine Specification
		java.awt.printerjob                     : sun.awt.windows.WPrinterJob
		sun.os.patch.level                      : 
		java.library.path                       : C:\class\dev\jdk-11\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\class\dev\jdk-11\bin;C:\Program Files\Bandizip\;C:\Program Files\Git\cmd;C:\Users\user\AppData\Local\Microsoft\WindowsApps;;.
		java.vendor                             : Oracle Corporation
		java.vm.info                            : mixed mode
		java.vm.version                         : 11.0.22+9-LTS-219
		java.specification.maintenance.version  : 2
		sun.io.unicode.encoding                 : UnicodeLittle
		java.class.version                      : 55.0
		*/
	}
}
