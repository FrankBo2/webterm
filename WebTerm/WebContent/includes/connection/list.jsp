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
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<wt:checkUser/>

<table>
	<tr>
		<td><s:text name="application.side.connections.title"/></td>
	</tr>
	<s:if test="result.processList.size > 0">
		<s:iterator value="result.processList">
			<tr id="row_<s:property value="id"/>">
				<td>
					<s:url id="connUrl" action="display" namespace="/connection">
						<s:param name="id" value="id" />
					</s:url>
					<sx:a href="%{connUrl}" targets="pageDiv">
						<s:property value="serverName"/>:<s:property value="port"/>[<s:property value="term.termName" />]
					</sx:a>
				</td>
			</tr>
		</s:iterator>
	</s:if>
</table>