<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<center><s:action name="/logon/execute">
	<table>
		<tr>
			<td><s:text name="logon.login"/></td>
			<td><s:textfield name="logon.login" /></td>
		</tr>
		<tr>
			<td><s:text name="logon.password"/></td>
			<td><s:textfield name="logon.password"/></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><s:submit><s:text name="logon.submit"/></s:submit></td>
		</tr>
	</table>
</s:action></center>