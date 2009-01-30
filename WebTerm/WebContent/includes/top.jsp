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
<%@page import="org.webterm.configuration.ConstConfiguration"%>

<wt:checkUser />

<table class="topTable">
	<tbody>
		<tr>
			<td class="topTableTdClose">
				<s:url id="logoffUrl" action="logoff" namespace="/logon" />
				<sx:a href="%{logoffUrl}" targets="mainDiv" showLoadingText="false">
					<img src="<%=request.getContextPath() %>/theme/<%=ConstConfiguration.APPLICATION_THEME %>/images/close.gif" alt="" border="0"/>
				</sx:a>
			</td>
			<td class="topTableTdUser"><wt:userName /></td>
			<td class="topTableTdTools">
				<s:url id="createConnUrl" action="create" namespace="/connection">
					<s:param name="init" value="true"/>
				</s:url>
				<sx:a href="%{createConnUrl}" targets="pageDiv" showLoadingText="false">
					<s:text name="application.top.createConnection" />
				</sx:a>
			</td>
		</tr>
	</tbody>
</table>
