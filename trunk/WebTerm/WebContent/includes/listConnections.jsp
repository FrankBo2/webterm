<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://webterm.org/tags-webterm" prefix="wt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<wt:checkUser/>

<p><s:text name="application.side.connections.title"/></p>
<s:if test="result.processList.size > 0">
	<table>
		<s:iterator value="result.processList">
			<tr id="row_<s:property value="id"/>">
				<td>
					<s:url id="connUrl" action="display" namespace="/connection">
						<s:param name="id" value="id" />
					</s:url>
					<s:a href="%{connUrl}" theme="ajax" targets="mainDiv">
						<s:property value="connDescription.serverName"/>:<s:property value="connDescription.port"/>[<s:property value="termName" />]
					</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
</s:if>