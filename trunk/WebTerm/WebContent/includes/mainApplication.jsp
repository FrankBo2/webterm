<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://webterm.org/tags-webterm" prefix="wt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<wt:checkUser/>

<s:div id="topDiv"  cssClass="topDiv"  theme="ajax" showLoadingText="false" href="includes/top.jsp" />
<s:div id="sideDiv" cssClass="sideDiv" theme="ajax" showLoadingText="false" href="connection/list.action" updateFreq="15000" />
<s:div id="pageDiv" cssClass="pageDiv" theme="ajax" showLoadingText="false">
test
</s:div>
