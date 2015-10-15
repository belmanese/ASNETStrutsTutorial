<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html locale="true">
	<head>
		<title><bean:message key="operator.update.title"/></title>
		<link href="views/resources/css/styles.css" rel="stylesheet" type="text/css"/>	
		<html:base/>
	</head>
	<body bgcolor="white">
	 	<h1 style="text-align:center;">REPORTE DE COSTOS Y MINUTOS</h1>
		<!-- TABLE OF REPORTS -->
		<html:form action="manage_report">
			<table border="1" class="center-table">
				<thead>
					<tr>
						<th class="cell-padding">Functionary</th>
						<th class="cell-padding">Department</th>
						<th class="cell-padding">Operator</th>
						<th class="cell-padding">Minutes</th>
						<th class="cell-padding">Cost</th>
					</tr>
				</thead>
				<tbody>
					<logic:iterate id="lineItem" name="reportFormView" property="reportListItems">
						<tr>
							<td class="cell-padding"><bean:write name="lineItem" property="functionaryName"/></td>
							<td class="cell-padding"><bean:write name="lineItem" property="departmentName"/></td>
							<td class="cell-padding"><bean:write name="lineItem" property="operatorName"/></td>
							<td class="cell-padding"><bean:write name="lineItem" property="minutes"/></td>
							<td class="cell-padding"><bean:write name="lineItem" property="cost"/></td>
						</tr>
					</logic:iterate>
				</tbody>
			</table><br/>
			<center>
				<html:submit property="manage" value="home" style="margin:0 auto;" />
			</center>		
		</html:form>
		
</html:html>