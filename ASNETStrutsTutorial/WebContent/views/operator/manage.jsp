<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<meta http-equiv="refresh" content="300;url=manageOperator.action" />

<html:html locale="true">
	<head>
		<title><bean:message key="operator.update.title"/></title>
		<html:base/>
		<link href="views/resources/css/styles.css" rel="stylesheet" type="text/css"/>	
	</head>
	<body bgcolor="white">
		<h1 style="text-align:center;">GESTION DE OPERADORES</h1>
	 	<!-- CREATE OPERATOR -->
		<html:form action="create_operator">
			<table border="1" style="margin: 0 auto;">
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
			<br/>
			<center>
				<html:submit property="manage" value="create" onclick="cleanOperators()" /><br/>
			</center>
		</html:form>
		<!-- LIST OF OPERATORS FOR UPDATE OR DELETE -->
		<html:form action="manage_operator">
			<table border="1" style="margin: 0 auto;">
				<tr>
					<th class="cell-padding"><bean:message key="operators.title.id"/></th>
					<th class="cell-padding"><bean:message key="operators.title.name"/></th>
					<th class="cell-padding"><bean:message key="operators.title.localMinute"/></th>
					<th class="cell-padding"><bean:message key="operators.title.internationalMinute"/></th>
					<th class="cell-padding"><bean:message key="operators.title.status"/></th>
					<th class="cell-padding"><bean:message key="manage.title.action"/></th>
				</tr>
				<logic:iterate id="lineItem" indexId="index" name="operatorFormView" property="operatorListItems">
					<tr>
						<%
						String sLineItem = "operatorListItems[" + index + "]";
						String nest= sLineItem + ".operator.";
						String checked = sLineItem + ".checked";
						String id = nest + "id";
						String name = nest + "name";
						String localMinute = nest + "localMinute";
						String internationalMinute = nest + "internationalMinute";
						String status = nest + "status";
						%>
						<td class="cell-padding"><html:text disabled="true" property="<%=id%>" /></td>
						<td class="cell-padding"><html:text property="<%=name%>" /></td>
						<td class="cell-padding"><html:text property="<%=localMinute%>" /></td>
						<td class="cell-padding"><html:text property="<%=internationalMinute%>" /></td>
						<td class="cell-padding">
							<html:select property="<%=status%>">
								<html:option value="true">true</html:option>
								<html:option value="false">false</html:option>
							</html:select>
						</td>
						<td class="cell-padding"><html:checkbox property="<%=checked%>" /></td>
					</tr>
				</logic:iterate>
			</table>
			<br/>
			<center>
				<html:submit property="manage" value="update" />
				<html:submit property="manage" value="delete" />
				<html:submit property="manage" value="home" />
			</center>		
		</html:form>
	</body>
	<script>
		function cleanOperators() {
			$('form[name="OperatorDispatchForm"]').attr("action", "/manageOperator?manage=read");
			$('form[name="OperatorDispatchForm"]').submit();
		}
	</script>
</html:html>