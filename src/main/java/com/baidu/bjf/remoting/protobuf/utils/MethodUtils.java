package com.baidu.bjf.remoting.protobuf.utils;

import java.lang.reflect.Method;

public class MethodUtils {
	public static Method findMethod(Class clazz, String methodName,
			final Class[] classes) {
		Method method = null;
		try {
			method = clazz.getDeclaredMethod(methodName, classes);
		} catch (NoSuchMethodException e) {
			try {
				method = clazz.getMethod(methodName, classes);
			} catch (NoSuchMethodException ex) {
				if (clazz.getSuperclass() == null) {
					return method;
				} else {
					method = findMethod(clazz.getSuperclass(), methodName,
							classes);
				}
			}
		}
		return method;
	}
}
