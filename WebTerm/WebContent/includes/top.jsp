<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://webterm.org/tags-webterm" prefix="wt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="org.webterm.configuration.ConstConfiguration"%>

<wt:checkUser />

<table class="topTable">
	<tbody>
		<tr>
			<td class="topTableTdClose">
				<s:url id="logoffUrl" action="logoff" namespace="/logon" />
				<s:a href="%{logoffUrl}" theme="ajax" targets="mainDiv" showLoadingText="false">
					<img src="<%=request.getContextPath() %>/theme/<%=ConstConfiguration.APPLICATION_THEME %>/images/close.gif" alt="" border="0"/>
				</s:a>
			</td>
			<td class="topTableTdUser"><wt:userName /></td>
			<td class="topTableTdTools">
				<s:url id="createConnUrl" action="create" namespace="/connection" />
				<s:a href="%{createConnUrl}" theme="ajax" targets="pageDiv" showLoadingText="false">
					<s:text name="application.top.createConnection" />
				</s:a>
			</td>
		</tr>
	</tbody>
</table>
