<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.math.BigDecimal" %>
<%

String S = "a0Ga88GABay67Aau8aaa";

String patternStr = "[A-Z]+";
Pattern pattern = Pattern.compile(patternStr);

String[] splitString = S.split("[0-9]");
int maxlength = -1;
for(int i = 0 ; i < splitString.length ; i++){
	String tmp = splitString[i];
	Matcher matcher = pattern.matcher(tmp);
	if(matcher.find()){        		
		maxlength = (tmp.length() > maxlength) ? tmp.length() : maxlength;
	}
}

out.println(maxlength);

%>