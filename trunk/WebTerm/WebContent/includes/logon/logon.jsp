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
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<center><s:form action="execute" namespace="/logon">
	<tr>
		<td colspan="2"><s:actionerror /> <s:fielderror /></td>
	</tr>
	<s:textfield key="logon.login" />
	<s:password key="logon.password" />
	<sx:submit key="logon.submit" targets="mainDiv" showLoadingText="false" />
</s:form></center>

