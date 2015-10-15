<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html locale="true">
<head>
	<title><bean:message key="welcome.title"/></title>
	<html:base/>
</head>
<body bgcolor="white">
	<h1 style="text-align: center;"><bean:message key="welcome.app"/></h1>	
	<div style="width: 350px; margin: 0 auto;">
		<html:link action="/manage_operator?manage=read">Gestion de Operadores Telefonicos.</html:link><br/><br/>
		<html:link action="/manage_functionary?manage=read">Gestion de Funcionarios.</html:link><br/><br/>
		<html:link action="/manage_report?manage=read">Generar Reportes.</html:link>
	</div>	
</body>
</html:html>