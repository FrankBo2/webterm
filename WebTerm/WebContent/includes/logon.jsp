<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<center><s:form action="execute" namespace="/logon">
	<table>
        <tr>
          <td colspan="2">
            <s:actionerror />
            <s:fielderror />
          </td>
        </tr>  
		<s:textfield key="logon.login"/>
		<s:password key="logon.password"/>
		<s:submit key="logon.submit" theme="ajax" targets="mainDiv"/>
	</table>
</s:form></center>