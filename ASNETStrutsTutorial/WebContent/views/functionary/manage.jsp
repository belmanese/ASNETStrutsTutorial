<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<meta http-equiv="refresh" content="300;url=manageOperator.action" />

<html:html locale="true">
	<head>
		<title><bean:message key="functionary.update.title"/></title>
		<html:base/>
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.js"></script>
	</head>
	<body bgcolor="white">
	 	<!-- CREATE OPERATOR -->
		<!-- <html:form action="createOperator">
			<table border="1">
				<tr>
					<td><bean:message key="operators.title.name" /></td>
					<td><html:text property="name" /></td>
				</tr>
				<tr>
					<td><bean:message key="operators.title.localMinute" /></td>
					<td><html:text property="localMinute" /></td>
				</tr>
				<tr>
					<td><bean:message key="operators.title.internationalMinute" /></td>
					<td><html:text property="internationalMinute" /></td>
				</tr>
				<tr>
					<td><bean:message key="operators.title.status" /></td>
					<td>
							<html:select property="status">
								<html:option value="true">true</html:option>
								<html:option value="false">false</html:option>
							</html:select>
					</td>
				</tr>
			</table>
			<br/><html:submit property="manage" value="create" onclick="cleanOperators()" /><br/>
		</html:form>-->
		<!-- LIST OF OPERATORS FOR UPDATE OR DELETE -->
		<html:form action="manageFunctionary">
			<table border="1">
				<tr>
					<th><bean:message key="functionary.title.id"/></th>
					<th><bean:message key="functionary.title.name"/></th>
					<th><bean:message key="functionary.title.salary"/></th>
					<th><bean:message key="functionary.title.department.name"/></th>
					<th><bean:message key="manage.title.action"/></th>
				</tr>
				<logic:iterate id="lineItem" indexId="index" name="functionaryFormView" property="functionaryListItems">
					<tr>
						<%
						String sLineItem = "functionaryListItems[" + index + "]";
						String nest= sLineItem + ".functionary.";
						String checked = sLineItem + ".checked";
						String id = nest + "id";
						String name = nest + "name";
						String salary = nest + "salary";
						String department = nest + "department.name";
						%>
						<td><html:text disabled="true" property="<%=id%>" /></td>
						<td><html:text property="<%=name%>" /></td>
						<td><html:text property="<%=salary%>" /></td>
						<td><html:text property="<%=department%>" /></td>
						<td><html:checkbox property="<%=checked%>" /></td>
					</tr>
				</logic:iterate>
			</table>
			<br/>		
			<html:submit property="manage" value="update" />
			<html:submit property="manage" value="delete" />
			<html:submit property="manage" value="home" />
		</html:form>
	</body>
	<script>
		function cleanOperators() {
			$('form[name="OperatorDispatchForm"]').attr("action", "/manageOperator?manage=read");
			$('form[name="OperatorDispatchForm"]').submit();
		}
	</script>
</html:html>