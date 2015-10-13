<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html locale="true">
<head>
	<title><bean:message key="welcome.title"/></title>
	<html:base/>
</head>
<body bgcolor="white">
	<h3><bean:message key="welcome.app"/></h3>
	<html:link action="/manageOperator?manage=read">Gestion de Operadores Telefonicos.</html:link><br/>
	<html:link action="/manageFunctionary?manage=read">Gestion de Funcionarios.</html:link>

</body>
</html:html>