<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://webterm.org/tags-webterm" prefix="wt"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<%
	request.getSession(true);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><wt:title/></title>
	<s:head theme="ajax" debug="false"/>
	<link href="<s:url value="/theme/default/main.css"/>" rel="stylesheet" type="text/css"/>
	<%-- main script --%>  
	<script type="text/javascript" src="<s:url value="/script/main.js"/>" ></script>
</head>
<body onload="resizeWindow()">

<s:div id="mainDiv" cssClass="mainDiv" theme="ajax" showLoadingText="false">
	<wt:ifUserConnected>
		<s:include value="/includes/mainApplication.jsp"/>
	</wt:ifUserConnected>
	<wt:ifUserNotConnected>
		<s:include value="/includes/logon/logon.jsp"/>
	</wt:ifUserNotConnected>
</s:div>

</body>
</html>