package com.happymama.admin.utils;

import java.net.InetAddress;

public class XmsUtils {

	public static String getLocalAddress() {
		try {
			InetAddress inet = InetAddress.getLocalHost();
			String canonicalHostName = inet.getCanonicalHostName();
			String hostAddress = inet.getHostAddress();
			return "IP:"+hostAddress + " HostName:" + canonicalHostName;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
