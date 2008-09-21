<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://webterm.org/tags-webterm" prefix="wt"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><wt:title/></title>
	<s:head theme="ajax" debug="false"/>
	<link href="<s:url value="/theme/default/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<s:div id="topDiv" theme="ajax">
</s:div>
<s:div id="sideDiv" theme="ajax">
</s:div>
<s:div id="mainDiv" theme="ajax">
	<s:include value="/includes/logon.jsp"></s:include>
</s:div>
</body>
</html>