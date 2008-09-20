<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<center><s:form action="execute" namespace="/logon" method="POST">
	<table>
		<s:textfield key="logon.login"/>
		<s:textfield key="logon.password"/>
		<s:submit key="logon.submit"/>
	</table>
</s:form></center>