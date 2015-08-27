package com.digital.backend.common.utils;

import java.util.*;
import java.io.*;

public class ActionForwardUtil {

	public String getForwardURL(String key) {
		String result = null;
		Properties pro = new Properties();
		try {
			pro.load(this.getClass().getClassLoader().getResourceAsStream("/action-forward.properties"));

			result = pro.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		}// end try-catch
		return result;
	}
}
