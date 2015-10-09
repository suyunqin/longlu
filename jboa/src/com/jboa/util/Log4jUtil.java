package com.jboa.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jUtil {
	private static Logger log = null;
	static {
		PropertyConfigurator.configure(".//src//log4j.properties");
	}

	public static Logger getLogger(Class<?> c) {
		log = Logger.getLogger(c);
		return log;
	}
}
