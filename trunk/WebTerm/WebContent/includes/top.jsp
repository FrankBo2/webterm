<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://webterm.org/tags-webterm" prefix="wt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<wt:checkUser />

<table>
	<tbody>
		<tr>
			<td>
				<s:url id="logoffUrl" action="logoff" namespace="/logon" />
				<s:a href="%{logoffUrl}" theme="ajax" targets="mainDiv">
					[X]
				</s:a>
			</td>
			<td><wt:userName /></td>
			<td>
				<s:url id="createConnUrl" action="create" namespace="/connection" />
				<s:a href="%{createConnUrl}" theme="ajax" targets="pageDiv">
					<s:text name="application.top.createConnection" />
				</s:a>
			</td>
		</tr>
	</tbody>
</table>
