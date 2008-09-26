<%--
 This file is part of WebTerm.

 WebTerm is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 WebTerm is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with WebTerm. If not, see <http://www.gnu.org/licenses/>.

 (C) COPYRIGHT 2008 - Charles FENDT
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://webterm.org/tags-webterm" prefix="wt"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<%@ page import="org.webterm.configuration.ConstConfiguration" %>
<% request.getSession(true); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><wt:title/></title>
	<s:head theme="ajax" debug="false"/>
	<link href="<%=request.getContextPath() %>/theme/<%=ConstConfiguration.APPLICATION_THEME %>/main.css" rel="stylesheet" type="text/css"/>
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